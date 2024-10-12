package com.grupo7.parkingmeter.usecase;

import com.grupo7.parkingmeter.provider.ParkingSpotProvider;
import com.grupo7.parkingmeter.provider.entity.ParkingSpot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingSpotUseCase {

    private final ParkingSpotProvider parkingSpotProvider;

    public ParkingSpot findById(Long id) {
        return parkingSpotProvider.findById(id);
    }

    public String create(ParkingSpot useCaseData) {
        return parkingSpotProvider.create(useCaseData);
    }

    public ParkingSpot update(Long id, ParkingSpot useCaseData) {
        return parkingSpotProvider.update(id, useCaseData);
    }

    public void delete(Long id) {
        parkingSpotProvider.delete(id);
    }

    public List<ParkingSpot> findAll() {
        return parkingSpotProvider.findAll();
    }

    public ParkingSpot findByCep(String cep) {
        parkingSpotProvider.findByCep(cep);
        return null;
    }
}
