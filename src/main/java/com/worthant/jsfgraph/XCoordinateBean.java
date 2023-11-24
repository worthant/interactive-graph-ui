package com.worthant.jsfgraph;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.validator.ValidatorException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * Managed bean for handling X coordinate value in JSF application.
 * Provides functionality to get and set X value, and to validate it.
 */
@Data
@NoArgsConstructor
public class XCoordinateBean implements Serializable {
    private Double x = 0.0;

    public void validateXBeanValue(Object o){
        if (o == null){
            FacesMessage message = new FacesMessage("X value should be in (-5, 5) interval");
            throw new ValidatorException(message);
        }
    }
}
