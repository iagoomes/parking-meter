package com.fiap.parkingmeter.service.mapper;

import com.fiap.parkingmeter.model.ParkingSpotRequest;
import com.fiap.parkingmeter.model.ParkingSpotResponse;
import com.fiap.parkingmeter.provider.entity.ParkingSpot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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
    @Mapping(target = "id", ignore = true)
    ParkingSpot toUseCaseData(ParkingSpotRequest parkingSpotRequest);
}