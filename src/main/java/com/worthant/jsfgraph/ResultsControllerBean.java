package com.worthant.jsfgraph;

import com.worthant.jsfgraph.db.DAOFactory;
import com.worthant.jsfgraph.entity.ResultEntity;
import com.worthant.jsfgraph.mbeans.*;
import com.worthant.jsfgraph.utils.AreaChecker;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Locale;

import javax.management.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Managed bean for handling results in JSF application.
 * This bean is responsible for managing operations related to result entities.
 */
@Getter
@Setter
@Slf4j
public class ResultsControllerBean implements Serializable {
    private XCoordinateBean xCoordinateBean;
    private YCoordinateBean yCoordinateBean;
    private RCoordinateBean rCoordinateBean;
    private PointsCounterMBean pointsCounter;
    private MissPercentageMBean missPercentage;

    private ArrayList<ResultEntity> results = new ArrayList<>();

    /**
     * Initializes the bean and loads existing results from the database.
     */
    @PostConstruct
    public void init() {
        var resultsEntities = DAOFactory.getInstance().getResultDAO().getAllResults();
        results = new ArrayList<>(resultsEntities);
        log.info("Results initialized with {} entries.", results.size());

        // Регистрация MBeans
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName pointsCounterName = new ObjectName("com.worthant.jsfgraph.mbeans:type=PointsCounter");
            pointsCounter = new PointsCounter(DAOFactory.getInstance().getResultDAO());
            mbs.registerMBean(pointsCounter, pointsCounterName);

            // Регистрация слушателя уведомлений
            NotificationListener listener = (notification, handback) -> System.out.println("Received notification: " + notification.getMessage());
            mbs.addNotificationListener(pointsCounterName, listener, null, null);

            missPercentage = new MissPercentage(pointsCounter);
            ObjectName missPercentageName = new ObjectName("com.worthant.jsfgraph.mbeans:type=MissPercentage");
            StandardMBean missPercentageMBean = new StandardMBean(missPercentage, MissPercentageMBean.class);
            mbs.registerMBean(missPercentageMBean, missPercentageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new result based on the provided coordinates and radius.
     * The method also calculates if the point is within the area and updates
     * the UI accordingly. Note: 'en' refers to a new instance of ResultEntity
     * (a.k.a. 'entity').
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @param r the radius for the area check
     */
    public void addResult(Double x, Double y, Double r) {
        boolean result = AreaChecker.isInArea(x, y, r);
        if (result) {
            pointsCounter.incrementTotalPoints();
            pointsCounter.resetConsecutiveMisses();
        } else {
            pointsCounter.incrementTotalPoints();
            pointsCounter.incrementMissedPoints();
        }

        ResultEntity en = ResultEntity.builder().x(x).y(y).r(r).result(result).build();

        results.add(en);
        DAOFactory.getInstance().getResultDAO().addNewResult(en);
        log.info("Added new result to the db: X={}, Y={}, R={}", x, y, r);

        String script = String.format(
                Locale.US, "window.drawDotOnCanvas(%f, %f, %f, %b, true);", x, y, r,
                result);
        FacesContext.getCurrentInstance()
                .getPartialViewContext()
                .getEvalScripts()
                .add(script);
    }

    /**
     * Redraws all the points on the canvas, based on the new radius.
     *
     * @param r new radius
     */
    public void updateCanvas(double r) {
        for (ResultEntity en : results) {
            boolean result = AreaChecker.isInArea(en.getX(), en.getY(), r);
            en.setR(r);
            en.setResult(result);

            String script = String.format(
                    Locale.US, "window.drawDotOnCanvas(%f, %f, %f, %b, true);",
                    en.getX(), en.getY(), r, result);
            System.out.println("Script: " + script);
            FacesContext.getCurrentInstance()
                    .getPartialViewContext()
                    .getEvalScripts()
                    .add(script);
        }
        log.info("Canvas updated with new radius: {}", r);
    }

    /**
     * Clears the database and locally stored array from all the points
     */
    public void clearResults() {
        DAOFactory.getInstance().getResultDAO().clearResults();
        results.clear();
        pointsCounter.resetAndInitializeCounts();
        log.info("All results cleared from database and local array.");
    }
}
