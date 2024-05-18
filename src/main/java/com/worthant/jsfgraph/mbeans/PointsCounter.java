package com.worthant.jsfgraph.mbeans;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Collection;

import com.worthant.jsfgraph.db.ResultDAO;
import com.worthant.jsfgraph.entity.ResultEntity;

public class PointsCounter extends NotificationBroadcasterSupport implements PointsCounterMBean {
    private AtomicInteger totalPoints = new AtomicInteger(0);
    private AtomicInteger missedPoints = new AtomicInteger(0);
    private int consecutiveMisses = 0;
    private long sequenceNumber = 1;
    private ResultDAO resultDAO;

    public PointsCounter(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
        initializeCounts();
    }

    private void initializeCounts() {
        totalPoints.set(0);
        missedPoints.set(0);
        Collection<ResultEntity> results = resultDAO.getAllResults();
        for (ResultEntity result : results) {
            totalPoints.incrementAndGet();
            if (!result.isResult()) {
                missedPoints.incrementAndGet();
            }
        }
    }

    public void resetAndInitializeCounts() {
        totalPoints.set(0);
        missedPoints.set(0);
        consecutiveMisses = 0;
        initializeCounts();
    }

    @Override
    public int getTotalPoints() {
        return totalPoints.get();
    }

    @Override
    public int getMissedPoints() {
        return missedPoints.get();
    }

    @Override
    public void incrementTotalPoints() {
        totalPoints.incrementAndGet();
    }

    @Override
    public void incrementMissedPoints() {
        missedPoints.incrementAndGet();
        consecutiveMisses++;
        if (consecutiveMisses == 2) {
            Notification n = new Notification("ConsecutiveMisses", this, sequenceNumber++,
                    System.currentTimeMillis(), "Two consecutive misses occurred");
            sendNotification(n);
            consecutiveMisses = 0;
        }
    }

    @Override
    public void resetConsecutiveMisses() {
        consecutiveMisses = 0;
    }
}