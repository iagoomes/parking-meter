package com.grupo7.parkingmeter.service;

import com.grupo7.parkingmeter.model.ParkingSpotRequest;
import com.grupo7.parkingmeter.model.ParkingSpotResponse;

import java.util.List;

public interface ParkingSpotService {
    List<ParkingSpotResponse> findAll();
    ParkingSpotResponse findById(Long id);
    ParkingSpotResponse findByCep(String cep);
    String create(ParkingSpotRequest parkingSpotRequest);
    ParkingSpotResponse update(Long id, ParkingSpotRequest parkingSpotRequest);
    void delete(Long id);
}