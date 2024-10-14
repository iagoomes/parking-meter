package com.fiap.parkingmeter.service;

import com.fiap.parkingmeter.model.ParkingSpotRequest;
import com.fiap.parkingmeter.model.ParkingSpotResponse;

import java.util.List;

/**
 * Service interface for managing parking spots.
 */
public interface ParkingSpotService {

    /**
     * Retrieves all parking spots.
     *
     * @return a list of all parking spots
     */
    List<ParkingSpotResponse> findAll();

    /**
     * Retrieves a parking spot by its ID.
     *
     * @param id the ID of the parking spot
     * @return the parking spot with the given ID
     */
    ParkingSpotResponse findById(Long id);

    /**
     * Retrieves a parking spot by its postal code (CEP).
     *
     * @param cep the postal code of the parking spot
     * @return the parking spot with the given postal code
     */
    ParkingSpotResponse findByCep(String cep);

    /**
     * Creates a new parking spot.
     *
     * @param parkingSpotRequest the parking spot data to create
     * @return the ID of the created parking spot
     */
    String create(ParkingSpotRequest parkingSpotRequest);

    /**
     * Updates an existing parking spot.
     *
     * @param id the ID of the parking spot to update
     * @param parkingSpotRequest the updated parking spot data
     * @return the updated parking spot
     */
    ParkingSpotResponse update(Long id, ParkingSpotRequest parkingSpotRequest);

    /**
     * Deletes a parking spot by its ID.
     *
     * @param id the ID of the parking spot to delete
     */
    void delete(Long id);
}