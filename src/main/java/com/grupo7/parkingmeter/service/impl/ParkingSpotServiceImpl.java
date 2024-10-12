package com.grupo7.parkingmeter.service.impl;

import com.grupo7.parkingmeter.model.ParkingSpotRequest;
import com.grupo7.parkingmeter.model.ParkingSpotResponse;
import com.grupo7.parkingmeter.service.ParkingSpotService;
import com.grupo7.parkingmeter.service.mapper.ParkingSpotMapper;
import com.grupo7.parkingmeter.usecase.ParkingSpotUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingSpotServiceImpl implements ParkingSpotService {

    private final ParkingSpotUseCase parkingSpotUseCase;
    private final ParkingSpotMapper parkingSpotMapper;


    @Override
    public List<ParkingSpotResponse> findAll() {
       return parkingSpotUseCase.findAll().stream().map(parkingSpotMapper::toDTO).toList();
    }

    @Override
    public ParkingSpotResponse findById(Long id) {
        return parkingSpotMapper.toDTO(parkingSpotUseCase.findById(id));
    }

    @Override
    public ParkingSpotResponse findByCep(String cep) {
        return parkingSpotMapper.toDTO(parkingSpotUseCase.findByCep(cep));
    }

    @Override
    public String create(ParkingSpotRequest parkingSpotRequest) {
        return parkingSpotUseCase.create(parkingSpotMapper.toUseCaseData(parkingSpotRequest));
    }

    @Override
    public ParkingSpotResponse update(Long id, ParkingSpotRequest parkingSpotRequest) {
        return parkingSpotMapper.toDTO(parkingSpotUseCase.update(id, parkingSpotMapper.toUseCaseData(parkingSpotRequest)));
    }

    @Override
    public void delete(Long id) {
        parkingSpotUseCase.delete(id);
    }
}
