package com.loripin.fullstackbackend.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "trims")
@Data
public class Trim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String altName;
    @Length(max = 10240)
    private String description;
    @ManyToOne
    @JoinColumn(name = "bodyType_id")
    private Bodystyle bodystyle;
    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;
    @ManyToOne
    @JoinColumn(name = "transmission_id")
    private Transmission transmission;
    @ManyToOne
    @JoinColumn(name = "body_id")
    private Body body;
    @ManyToOne
    @JoinColumn(name = "drivetrain_id")
    private Drivetrain drivetrain;
    private String years;
    @ManyToOne
    @JoinColumn(name = "tuner_id")
    private Make tuner;
    private String amount;
    private String maxSpeed;
    private String acceleration;
    private Boolean uniq;
    private String length;
    private String height;
    private String width;
    private String base;
    private String weight;
    private String power;
    private String torque;
    private String engineVolume;
    private String fuel;
    private Boolean electric;
    private Boolean hybrid;
    private String battery;
    private String range;
    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;
    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;
    @OneToMany
    @CollectionTable(name = "trim_photos")
    private List<Photo> photos;
}
