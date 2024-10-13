package com.grupo7.parkingmeter.resource;

import com.grupo7.parkingmeter.api.ParkingSpotApiDelegate;
import com.grupo7.parkingmeter.model.ParkingSpotRequest;
import com.grupo7.parkingmeter.model.ParkingSpotResponse;
import com.grupo7.parkingmeter.service.ParkingSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Resource class for managing parking spots in the resource layer.
 */
@Component
@RequiredArgsConstructor
public class ParkingSpotResource implements ParkingSpotApiDelegate {

    private final ParkingSpotService parkingSpotService;

    /**
     * Retrieves all parking spots.
     *
     * @return a CompletableFuture containing a ResponseEntity with a list of all parking spots
     */
    @Override
    public CompletableFuture<ResponseEntity<List<ParkingSpotResponse>>> findAllSpots() {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().body(parkingSpotService.findAll()));
    }

    /**
     * Retrieves a parking spot by its ID.
     *
     * @param id the ID of the parking spot
     * @return a CompletableFuture containing a ResponseEntity with the parking spot
     */
    @Override
    public CompletableFuture<ResponseEntity<ParkingSpotResponse>> findById(Long id) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().body(parkingSpotService.findById(id)));
    }

    /**
     * Retrieves a parking spot by its postal code (CEP).
     *
     * @param cep the postal code of the parking spot
     * @return a CompletableFuture containing a ResponseEntity with the parking spot
     */
    @Override
    public CompletableFuture<ResponseEntity<ParkingSpotResponse>> findByCep(String cep) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().body(parkingSpotService.findByCep(cep)));
    }

    /**
     * Creates a new parking spot.
     *
     * @param parkingSpotDto the parking spot data to create
     * @return a CompletableFuture containing a ResponseEntity with the ID of the created parking spot
     */
    @Override
    public CompletableFuture<ResponseEntity<String>> createSpot(ParkingSpotRequest parkingSpotDto) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().body(parkingSpotService.create(parkingSpotDto)));
    }

    /**
     * Updates an existing parking spot.
     *
     * @param id the ID of the parking spot to update
     * @param parkingSpotDto the updated parking spot data
     * @return a CompletableFuture containing a ResponseEntity with the updated parking spot
     */
    @Override
    public CompletableFuture<ResponseEntity<ParkingSpotResponse>> updateParkingSpot(Long id, ParkingSpotRequest parkingSpotDto) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().body(parkingSpotService.update(id, parkingSpotDto)));
    }

    /**
     * Deletes a parking spot by its ID.
     *
     * @param id the ID of the parking spot to delete
     * @return a CompletableFuture containing a ResponseEntity with no content
     */
    @Override
    public CompletableFuture<ResponseEntity<Void>> deleteParkingSpot(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            parkingSpotService.delete(id);
            return ResponseEntity.ok().build();
        });
    }
}