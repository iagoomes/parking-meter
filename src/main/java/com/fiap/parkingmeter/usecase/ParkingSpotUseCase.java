package com.fiap.parkingmeter.usecase;

import com.fiap.parkingmeter.provider.ParkingSpotProvider;
import com.fiap.parkingmeter.provider.entity.ParkingSpot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Use case class for managing parking spots.
 */
@Service
@RequiredArgsConstructor
public class ParkingSpotUseCase {

    private final ParkingSpotProvider parkingSpotProvider;

    /**
     * Retrieves all parking spots.
     *
     * @return a list of all parking spots
     */
    public List<ParkingSpot> findAll() {
        return parkingSpotProvider.findAll();
    }

    /**
     * Retrieves a parking spot by its ID.
     *
     * @param id the ID of the parking spot
     * @return the parking spot with the given ID
     */
    public ParkingSpot findById(Long id) {
        return parkingSpotProvider.findById(id);
    }

    /**
     * Retrieves a parking spot by its postal code (CEP).
     *
     * @param cep the postal code of the parking spot
     * @return the parking spot with the given postal code
     */
    public ParkingSpot findByCep(String cep) {
        return parkingSpotProvider.findByCep(cep);
    }

    /**
     * Creates a new parking spot.
     *
     * @param useCaseData the parking spot data to create
     * @return the ID of the created parking spot
     */
    public String create(ParkingSpot useCaseData) {
        return parkingSpotProvider.create(useCaseData);
    }

    /**
     * Updates an existing parking spot.
     *
     * @param id the ID of the parking spot to update
     * @param useCaseData the updated parking spot data
     * @return the updated parking spot
     */
    public ParkingSpot update(Long id, ParkingSpot useCaseData) {
        return parkingSpotProvider.update(id, useCaseData);
    }

    /**
     * Deletes a parking spot by its ID.
     *
     * @param id the ID of the parking spot to delete
     */
    public void delete(Long id) {
        parkingSpotProvider.delete(id);
    }
}