package com.worthant;

import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.ConverterException;

@FacesConverter("com.worthant.CommaToDotConverter")
public class CommaToDotConverter implements Converter<Double> {

    @Override
    public Double getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        try {
            return Double.parseDouble(value.replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new ConverterException("Invalid format");
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Double value) {
        if (value == null) {
            return "";
        }
        return value.toString();
    }
}

