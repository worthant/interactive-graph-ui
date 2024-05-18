package com.worthant.jsfgraph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.worthant.jsfgraph.utils.AreaChecker;
import org.junit.jupiter.api.Test;

public class AreaCheckerTest {

    @Test
    public void testIsInAreaForRectangle() {
        // Inside the rectangle
        assertTrue(AreaChecker.isInArea(5, 1, 10));
        assertTrue(AreaChecker.isInArea(10, 5, 10));
        assertTrue(AreaChecker.isInArea(2, 5, 10));

        // Outside the rectangle
        assertFalse(AreaChecker.isInArea(11, 1, 10));
        assertFalse(AreaChecker.isInArea(7, 6, 10));
    }

    @Test
    public void testIsInAreaForSemiCircle() {
        // Inside the semi-circle
        assertTrue(AreaChecker.isInArea(-5, 0, 10));
        assertTrue(AreaChecker.isInArea(0, -5, 10));
        assertTrue(AreaChecker.isInArea(-5, 0, 10));
        assertTrue(AreaChecker.isInArea(0, 0, 10));

        // Outside the semi-circle
        assertFalse(AreaChecker.isInArea(-5, 1, 10));
        assertFalse(AreaChecker.isInArea(-10, -10, 10));
    }

    @Test
    public void testIsInAreaForTriangle() {
        // Inside the triangle
        assertTrue(AreaChecker.isInArea(5, 0, 10));

        // Outside the triangle
        assertFalse(AreaChecker.isInArea(10.1, 0, 10));
        assertFalse(AreaChecker.isInArea(6, -5, 10));
    }

    @Test
    public void testIsInAreaOutsideAllRegions() {
        // Inside some region
        assertTrue(AreaChecker.isInArea(5, 1, 10));

        // Outside all regions
        assertFalse(AreaChecker.isInArea(-0.000001, 0.0000001, 4));
        assertFalse(AreaChecker.isInArea(-4, 0.00000001, 10));
        assertFalse(AreaChecker.isInArea(-456, 0, 10));
        assertFalse(AreaChecker.isInArea(4564, 0, 43));
        assertFalse(AreaChecker.isInArea(0, 354634563, 43));
        assertFalse(AreaChecker.isInArea(0, -345635634, 43));
    }

    @Test
    public void testForZeroCoords() {
        assertTrue(AreaChecker.isInArea(0, 0, 10),
                "Точка в центре должна быть в области");
        assertFalse(
                AreaChecker.isInArea(0, 0, 0),
                "При нулевом радиусе точка не должна быть внутри области, даже в центре");
    }

    @Test
    public void testBoundaryConditions() {
        // Граничные условия для полукруга
        assertTrue(AreaChecker.isInArea(-5, 0, 10),
                "Точка на границе полукруга должна быть внутри.");
        assertFalse(AreaChecker.isInArea(-5.1, 0, 10),
                "Точка вне границы полукруга должна быть снаружи.");

        // Граничные условия для прямоугольника
        assertTrue(AreaChecker.isInArea(10, 5, 10),
                "Точка на границе прямоугольника должна быть внутри.");
        assertFalse(AreaChecker.isInArea(10.1, 5, 10),
                "Точка вне границ прямоугольника должна быть снаружи.");

        // Граничные условия для треугольника
        assertTrue(AreaChecker.isInArea(5, 0, 10),
                "Точка на границе треугольника должна быть внутри.");
        assertFalse(AreaChecker.isInArea(5.1, -0.1, 10),
                "Точка вне границ треугольника должна быть снаружи.");
    }
}
