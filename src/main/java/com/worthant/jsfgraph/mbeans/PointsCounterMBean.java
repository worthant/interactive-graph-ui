package com.worthant.jsfgraph.mbeans;

public interface PointsCounterMBean {
    int getTotalPoints();
    int getMissedPoints();
    void incrementTotalPoints();
    void incrementMissedPoints();
    void resetConsecutiveMisses();
    void resetAndInitializeCounts();
}