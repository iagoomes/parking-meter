package com.grupo7.parkingmeter.service.mapper;

import com.grupo7.parkingmeter.model.ParkingSpotRequest;
import com.grupo7.parkingmeter.model.ParkingSpotResponse;
import com.grupo7.parkingmeter.provider.entity.ParkingSpot;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between ParkingSpot entities and DTOs.
 */
@Mapper(componentModel = "spring")
public interface ParkingSpotMapper {

    /**
     * Converts a ParkingSpot entity to a ParkingSpotResponse DTO.
     *
     * @param parkingSpot the ParkingSpot entity to convert
     * @return the converted ParkingSpotResponse DTO
     */
    ParkingSpotResponse toDTO(ParkingSpot parkingSpot);

    /**
     * Converts a ParkingSpotRequest DTO to a ParkingSpot entity.
     *
     * @param parkingSpotRequest the ParkingSpotRequest DTO to convert
     * @return the converted ParkingSpot entity
     */
    ParkingSpot toUseCaseData(ParkingSpotRequest parkingSpotRequest);
}