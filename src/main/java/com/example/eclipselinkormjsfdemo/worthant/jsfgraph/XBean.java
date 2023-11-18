package com.example.eclipselinkormjsfdemo.worthant.jsfgraph;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.validator.ValidatorException;

import java.io.Serializable;
import java.util.Objects;

public class XBean implements Serializable {
    private Double x = 0.0;

    public Double getXBeanValue(){
        return x;
    }

    public void setXBeanValue(Double x) {
        this.x = x;
    }

    public void validateXBeanValue(Object o){
        if (o == null){
            FacesMessage message = new FacesMessage("Input X!");
            throw new ValidatorException(message);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XBean xBean = (XBean) o;
        return Objects.equals(x, xBean.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }

    @Override
    public String toString() {
        return "XBean{" +
                "x=" + x +
                '}';
    }
}
