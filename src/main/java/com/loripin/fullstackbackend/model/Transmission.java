package com.loripin.fullstackbackend.model;

import lombok.Data;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "transmissions")
@Data
public class Transmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String description;
    @ElementCollection
    @CollectionTable(name = "transmission_photos", joinColumns = @JoinColumn(name = "transmission_id"))
    private List<Photo> photos;
}