package com.grupo7.parkingmeter.resource;

import com.grupo7.parkingmeter.api.ParkingSpotsApiDelegate;
import com.grupo7.parkingmeter.model.ParkingSpotRequest;
import com.grupo7.parkingmeter.model.ParkingSpotResponse;
import com.grupo7.parkingmeter.service.ParkingSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class ParkingSpotResource implements ParkingSpotsApiDelegate {

    private final ParkingSpotService parkingSpotService;

    @Override
    public CompletableFuture<ResponseEntity<List<ParkingSpotResponse>>> findAllSpots() {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().body(parkingSpotService.findAll()));
    }

    @Override
    public CompletableFuture<ResponseEntity<ParkingSpotResponse>> findById(Long id) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().body(parkingSpotService.findById(id)));
    }

    @Override
    public CompletableFuture<ResponseEntity<ParkingSpotResponse>> findByCep(String cep) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().body(parkingSpotService.findByCep(cep)));
    }

    @Override
    public CompletableFuture<ResponseEntity<String>> createSpot(ParkingSpotRequest parkingSpotDto) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().body(parkingSpotService.create(parkingSpotDto)));
    }

    @Override
    public CompletableFuture<ResponseEntity<ParkingSpotResponse>> updateParkingSpot(Long id, ParkingSpotRequest parkingSpotDto) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().body(parkingSpotService.update(id, parkingSpotDto)));
    }

    @Override
    public CompletableFuture<ResponseEntity<Void>> deleteParkingSpot(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            parkingSpotService.delete(id);
            return ResponseEntity.ok().build();
        });
    }
}