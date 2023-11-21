package com.worthant.jsfgraph;

import com.worthant.jsfgraph.db.DAOFactory;
import com.worthant.jsfgraph.entity.ResultEntity;
import com.worthant.jsfgraph.utils.AreaChecker;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;


/**
 * Managed bean for handling results in JSF application.
 * This bean is responsible for managing operations related to result entities.
 */
public class ResultsControllerBean implements Serializable {
    private XCoordinateBean xCoordinateBean;
    private YCoordinateBean yCoordinateBean;
    private RCoordinateBean rCoordinateBean;

    private ArrayList<ResultEntity> results = new ArrayList<>();

    /**
     * Initializes the bean and loads existing results from the database.
     */
    @PostConstruct
    public void init() {
        var resultsEntities = DAOFactory.getInstance().getResultDAO().getAllResults();
        results = new ArrayList<>(resultsEntities);
    }

    /**
     * Adds a new result based on the provided coordinates and radius.
     * The method also calculates if the point is within the area and updates the UI accordingly.
     * Note: 'en' refers to a new instance of ResultEntity (a.k.a. 'entity').
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @param r the radius for the area check
     */
    public void addResult(Double x, Double y, Double r) {
        ResultEntity en = new ResultEntity();
        boolean result = AreaChecker.isInArea(x, y, r);
        en.setX(x);
        en.setY(y);
        en.setR(r);
        en.setResult(result);

        results.add(en);
        DAOFactory.getInstance().getResultDAO().addNewResult(en);

        String script = String.format(Locale.US, "window.drawDotOnCanvas(%f, %f, %f, %b, true);", x, y, r, result);
        FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts().add(script);
    }

    /**
     * Redraws all the points on the canvas, based on the new radius.
     *
     * @param r new radius
     */
    public void updateCanvas(double r) {
        System.out.println("Updating r value: " + r);
        for (ResultEntity en : results) {
            boolean result = AreaChecker.isInArea(en.getX(), en.getY(), r);
            en.setR(r);
            en.setResult(result);

            String script = String.format(Locale.US, "window.drawDotOnCanvas(%f, %f, %f, %b, true);", en.getX(), en.getY(), r, result);
            System.out.println("Script: " + script);
            FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts().add(script);

        }
        System.out.println("Drawing...");
    }

    /**
     * Clears the database and locally stored array from all the points
     */
    public void clearResults() {
        System.out.println("Clearing the database...");
        DAOFactory.getInstance().getResultDAO().clearResults();
        results.clear();
        System.out.println("Database and local results array cleared");
        System.out.println("Results array size: " + results.size());
    }
    public XCoordinateBean getXCoordinateBean() {
        return xCoordinateBean;
    }

    public void setXCoordinateBean(XCoordinateBean xCoordinateBean) {
        this.xCoordinateBean = xCoordinateBean;
    }

    public YCoordinateBean getYCoordinateBean() {
        return yCoordinateBean;
    }

    public void setYCoordinateBean(YCoordinateBean yCoordinateBean) {
        this.yCoordinateBean = yCoordinateBean;
    }

    public RCoordinateBean getRCoordinateBean() {
        return rCoordinateBean;
    }

    public void setRCoordinateBean(RCoordinateBean rCoordinateBean) {
        this.rCoordinateBean = rCoordinateBean;
    }

    public ArrayList<ResultEntity> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultEntity> results) {
        this.results = results;
    }
}

