package com.loripin.fullstackbackend.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "engines")
@Data
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String volume;
    private String power;
    private String engineType;
    private String torque;
    private String fuel;
    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;
    @Length(max = 10240)
    private String description;
    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;
}