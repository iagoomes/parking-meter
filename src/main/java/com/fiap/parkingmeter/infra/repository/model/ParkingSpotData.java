package com.fiap.parkingmeter.infra.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Data;

/**
 * Entity representing a parking spot.
 */
@Data
@Entity
@Table(name = "parking_spots")
public class ParkingSpotData {

    /**
     * Unique identifier for the parking spot.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Postal code (CEP) of the parking spot.
     */
    private String cep;

    /**
     * Location identifier, such as the spot number or area name.
     */
    private String location;

    /**
     * Street name (Logradouro) of the parking spot.
     */
    private String logradouro;

    /**
     * Neighborhood of the parking spot.
     */
    private String bairro;

    /**
     * City where the parking spot is located.
     */
    private String cidade;

    /**
     * State where the parking spot is located.
     */
    private String estado;

    /**
     * Country where the parking spot is located.
     */
    private String pais;

    /**
     * Quantity of parking spots available.
     */
    private int quantity;
}