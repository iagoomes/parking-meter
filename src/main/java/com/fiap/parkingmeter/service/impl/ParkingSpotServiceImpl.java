package com.fiap.parkingmeter.service.impl;

import com.fiap.parkingmeter.model.ParkingSpotRequest;
import com.fiap.parkingmeter.model.ParkingSpotResponse;
import com.fiap.parkingmeter.service.ParkingSpotService;
import com.fiap.parkingmeter.service.mapper.ParkingSpotMapper;
import com.fiap.parkingmeter.usecase.ParkingSpotUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing parking spots.
 */
@Service
@RequiredArgsConstructor
public class ParkingSpotServiceImpl implements ParkingSpotService {

    private final ParkingSpotUseCase parkingSpotUseCase;
    private final ParkingSpotMapper parkingSpotMapper;

    /**
     * Retrieves all parking spots.
     *
     * @return a list of all parking spots
     */
    @Override
    public List<ParkingSpotResponse> findAll() {
       return parkingSpotUseCase.findAll().stream().map(parkingSpotMapper::toDTO).toList();
    }

    /**
     * Retrieves a parking spot by its ID.
     *
     * @param id the ID of the parking spot
     * @return the parking spot with the given ID
     */
    @Override
    public ParkingSpotResponse findById(Long id) {
        return parkingSpotMapper.toDTO(parkingSpotUseCase.findById(id));
    }

    /**
     * Retrieves a parking spot by its postal code (CEP).
     *
     * @param cep the postal code of the parking spot
     * @return the parking spot with the given postal code
     */
    @Override
    public ParkingSpotResponse findByCep(String cep) {
        return parkingSpotMapper.toDTO(parkingSpotUseCase.findByCep(cep));
    }

    /**
     * Creates a new parking spot.
     *
     * @param parkingSpotRequest the parking spot data to create
     * @return the ID of the created parking spot
     */
    @Override
    public String create(ParkingSpotRequest parkingSpotRequest) {
        return parkingSpotUseCase.create(parkingSpotMapper.toUseCaseData(parkingSpotRequest));
    }

    /**
     * Updates an existing parking spot.
     *
     * @param id the ID of the parking spot to update
     * @param parkingSpotRequest the updated parking spot data
     * @return the updated parking spot
     */
    @Override
    public ParkingSpotResponse update(Long id, ParkingSpotRequest parkingSpotRequest) {
        return parkingSpotMapper.toDTO(parkingSpotUseCase.update(id, parkingSpotMapper.toUseCaseData(parkingSpotRequest)));
    }

    /**
     * Deletes a parking spot by its ID.
     *
     * @param id the ID of the parking spot to delete
     */
    @Override
    public void delete(Long id) {
        parkingSpotUseCase.delete(id);
    }
}