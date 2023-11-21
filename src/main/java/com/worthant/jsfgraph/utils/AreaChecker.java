package com.worthant.jsfgraph.utils;

/**
 * Utility class to check if a point lies within a defined area.
 */
public class AreaChecker {
    /**
     * Checks if a given point (x, y) lies within an area defined by radius r.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @param r the radius defining the area
     * @return true if the point is within the area, false otherwise
     */
    public static boolean isInArea(double x, double y, double r){
        if (x >= 0 && y >= 0) { // Check for rectangle in the top-right quadrant
            return x < r && y <= r/2;
        }
        if (x >= 0 && y <= 0) { // Check for triangle in bottom-right quadrant
            return (x <= r / 2) && (y >= -r) && (2 * x - y <= r);
        }
        if (x <= 0 && y <= 0) { // Check for the circle in the bottom-left quadrant
            return (x * x + y * y) <= (r * r) / 4;
        }
        return false;
    }
}