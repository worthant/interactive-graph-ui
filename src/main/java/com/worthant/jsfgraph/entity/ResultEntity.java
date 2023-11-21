package com.worthant.jsfgraph.entity;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Represents a result entity for storing point data.
 * This entity is mapped to a database table 'point_model' within the schema 's368090'.
 * It includes information about the point coordinates (x, y), radius (r) and whether the point is within a certain area (result).
 */
@Entity
@Table(name = "point_model", schema = "s368090")
public class ResultEntity {
    private long id;
    private double x;

    private double y;

    private double r;

    private boolean result;

    @Id
    @Column
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence-generator"
    )
    @SequenceGenerator(
            name = "sequence-generator",
            sequenceName = "point_model_id_seq",
            allocationSize = 1
    )
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Column
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Column
    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Column
    public boolean getResult() { return result; }

    public void setResult(boolean result) { this.result = result; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultEntity that)) return false;
        return getId() == that.getId() && Double.compare(getX(), that.getX()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getX());
    }

    @Override
    public String toString() {
        return "XBeanEntity{" +
                "id=" + id +
                ", x=" + x +
                '}';
    }
}