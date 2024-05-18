package com.worthant.jsfgraph.mbeans;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.util.concurrent.atomic.AtomicInteger;

public class PointsCounter extends NotificationBroadcasterSupport implements PointsCounterMBean {
    private AtomicInteger totalPoints = new AtomicInteger(0);
    private AtomicInteger missedPoints = new AtomicInteger(0);
    private int consecutiveMisses = 0;

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
            sendNotification(new Notification("ConsecutiveMisses", this, 0));
            consecutiveMisses = 0;
        }
    }

    @Override
    public void resetConsecutiveMisses() {
        consecutiveMisses = 0;
    }
}