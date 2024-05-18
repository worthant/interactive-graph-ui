package com.worthant.jsfgraph.utils;

/**
 * Utility class to check if a point lies within a defined area.
 */
public class AreaChecker {

    /**
     * Checks if a given point (x, y) lies within the defined area by radius r.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @param r the radius defining the area
     * @return true if the point is within the area, false otherwise
     */
    public static boolean isInArea(double x, double y, double r) {
        if (r == 0) {
            return false;
        }
        // Check for the rectangle in the top-right quadrant
        if (x >= 0 && y >= 0) {
            return x <= r && y <= r / 2;
        }
        // Check for the semicircle in the bottom-left quadrant
        else if (x <= 0 && y <= 0) {
            return (x * x + y * y) <= (r * r) / 4;
        }
        // Check for the triangle in the bottom-right quadrant
        else if (x >= 0 && y <= 0) {
            return y >= (2*x - r);
        }
        return false;
    }
}
