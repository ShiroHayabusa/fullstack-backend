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
@Table(name = "generations")
@Data
public class Generation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    private String years;
    @ManyToOne
    @JoinColumn(name = "body_id")
    private Body body;
    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;
    @Length(max = 10240)
    private String description;
}