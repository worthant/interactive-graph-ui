package com.worthant.jsfgraph;

import java.io.Serializable;

/**
 * Managed bean for handling coordinate inputs in JSF application.
 */
public class CoordinateHandlerBean implements Serializable {

    private double x;
    private double y;

    private double r;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}