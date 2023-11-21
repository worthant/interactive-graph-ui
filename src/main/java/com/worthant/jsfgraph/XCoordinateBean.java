package com.worthant.jsfgraph;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.validator.ValidatorException;

import java.io.Serializable;
import java.util.Objects;

/**
 * Managed bean for handling X coordinate value in JSF application.
 * Provides functionality to get and set X value, and to validate it.
 */
public class XCoordinateBean implements Serializable {
    private Double x = 0.0;

    public Double getXBeanValue(){
        return x;
    }

    public void setXBeanValue(Double x) {
        this.x = x;
    }

    public void validateXBeanValue(Object o){
        if (o == null){
            FacesMessage message = new FacesMessage("X value should be in (-5, 5) interval");
            throw new ValidatorException(message);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XCoordinateBean xCoordinateBean = (XCoordinateBean) o;
        return Objects.equals(x, xCoordinateBean.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }

    @Override
    public String toString() {
        return "XCoordinateBean{" +
                "x=" + x +
                '}';
    }
}
