package com.worthant.jsfgraph;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.validator.ValidatorException;

import java.io.Serializable;
import java.util.Objects;

/**
 * Managed bean for handling Y coordinate value in JSF application.
 * Offers methods to get and set Y value, and a validator to ensure the Y value falls within a specified range.
 */
public class YCoordinateBean implements Serializable {
    private Double y = 0.0;

    public Double getYBeanValue(){
        return y;
    }

    public void setYBeanValue(Double y){
        this.y = y;
    }

    public void validateYBeanValue(Object o){
        if (o == null){
            FacesMessage message = new FacesMessage("Y value should be in (-3, 5) interval");
            throw new ValidatorException(message);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YCoordinateBean yBean = (YCoordinateBean) o;
        return Objects.equals(y, yBean.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(y);
    }

    @Override
    public String toString() {
        return "YCoordinateBean{" +
                "yValue=" + y +
                '}';
    }
}
