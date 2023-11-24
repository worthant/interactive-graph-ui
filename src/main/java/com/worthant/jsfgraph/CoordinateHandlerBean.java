package com.worthant.jsfgraph;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Managed bean for handling coordinate inputs in JSF application.
 */
@Data
@NoArgsConstructor
public class CoordinateHandlerBean implements Serializable {
    private double x;
    private double y;
    private double r;
}