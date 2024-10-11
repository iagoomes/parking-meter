package com.grupo7.parkingmeter.infra.repository;

import com.grupo7.parkingmeter.infra.repository.model.ParkingSpotData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpotData, Long> {

    // Método para buscar todos os ParkingSpots por CEP
    Optional<ParkingSpotData> findByCep(String cep);

    Optional<ParkingSpotData> findByCepAndLocation(String cep, String location);

    void deleteByCepAndLocation(String cep, String location);
}
