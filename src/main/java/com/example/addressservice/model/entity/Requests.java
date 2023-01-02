package com.example.addressservice.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Requests implements GenericEntity<Long> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String number;
    private String city;
    private String complement;
    private String zipCode;
    private String district;
    private String state;
    private String country;
    
    @Column(nullable = true)
    private Double latitude;
    @Column(nullable = true)
    private Double longitude;

    @ManyToOne
    private Carriers carrier;

}
