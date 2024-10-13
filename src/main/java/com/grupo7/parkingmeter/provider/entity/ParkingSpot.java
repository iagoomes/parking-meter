package com.grupo7.parkingmeter.provider.entity;

import lombok.Data;

/**
 * Entity representing a parking spot in the provider layer.
 */
@Data
public class ParkingSpot {

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