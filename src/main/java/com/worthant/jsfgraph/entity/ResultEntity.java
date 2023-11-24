package com.worthant.jsfgraph.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * Represents a result entity for storing point data.
 * This entity is mapped to a database table 'point_model' within the schema 'UNI_NUMBER'.
 * It includes information about the point coordinates (x, y), radius (r) and whether the point is within a certain area (result).
 */
@Entity
@Table(name = "point_model", schema = "UNI_NUMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator", sequenceName = "point_model_id_seq", allocationSize = 1)
    private long id;

    private double x;
    private double y;
    private double r;
    private boolean result;
}