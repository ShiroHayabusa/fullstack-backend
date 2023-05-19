package com.loripin.fullstackbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "bodystyles")
@Data
public class Bodystyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "generation_id")
    private Generation generation;
    @ManyToOne
    @JoinColumn(name = "facelift_id")
    private Facelift facelift;
    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;
    private String years;
    @Length(max = 10240)
    private String description;
    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;
}