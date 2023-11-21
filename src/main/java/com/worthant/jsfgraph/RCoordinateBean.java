package com.worthant.jsfgraph;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;

import java.io.Serializable;
import java.util.Objects;

/**
 * Managed bean for dealing with the R value in a JSF application.
 * This bean includes methods for getting and setting the R value, validating it, and initializing it with a default value if necessary.
 */
public class RCoordinateBean implements Serializable {
    private Double r = 0.0;

    public Double getRBeanValue(){
        return r;
    }

    public void setRBeanValue(Double r){
        this.r = r;
    }

    public void validateRBeanValue(FacesContext facesContext, UIComponent uiComponent, Object o){
        if (o == null){
            FacesMessage message = new FacesMessage("R value should be in (1, 4) interval");
            throw new ValidatorException(message);
        }
    }

    @PostConstruct
    public void init() {
        if (r == null || r == 0.0) {
            r = 3.0; // Default value
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RCoordinateBean rBean = (RCoordinateBean) o;
        return Objects.equals(r, rBean.r);
    }

    @Override
    public int hashCode(){
        return Objects.hash(r);
    }

    @Override
    public String toString(){
        return "RCoordinateBean{" +
                "value" + r +
                "}";
    }
}
