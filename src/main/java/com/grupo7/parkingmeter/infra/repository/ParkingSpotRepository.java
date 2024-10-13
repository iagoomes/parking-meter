package com.grupo7.parkingmeter.infra.repository;

import com.grupo7.parkingmeter.infra.repository.model.ParkingSpotData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for managing ParkingSpotData entities.
 */
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotData, Long> {

    /**
     * Finds a parking spot by its postal code (CEP).
     *
     * @param cep the postal code of the parking spot
     * @return an Optional containing the found ParkingSpotData, or empty if not found
     */
    Optional<ParkingSpotData> findByCep(String cep);

    /**
     * Finds a parking spot by its postal code (CEP) and location.
     *
     * @param cep the postal code of the parking spot
     * @param location the location of the parking spot
     * @return an Optional containing the found ParkingSpotData, or empty if not found
     */
    Optional<ParkingSpotData> findByCepAndLocation(String cep, String location);
}