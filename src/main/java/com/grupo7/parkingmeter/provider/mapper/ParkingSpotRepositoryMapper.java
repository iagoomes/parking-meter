package com.grupo7.parkingmeter.provider.mapper;

import com.grupo7.parkingmeter.infra.repository.model.ParkingSpotData;
import com.grupo7.parkingmeter.provider.entity.ParkingSpot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper interface for converting between ParkingSpot domain entities and ParkingSpotData repository entities.
 */
@Mapper(componentModel = "spring")
public interface ParkingSpotRepositoryMapper {

    /**
     * Converts a ParkingSpotData repository entity to a ParkingSpot domain entity.
     *
     * @param parkingSpotData the ParkingSpotData entity to convert
     * @return the converted ParkingSpot domain entity
     */
    ParkingSpot toDomain(ParkingSpotData parkingSpotData);

    /**
     * Converts a ParkingSpot domain entity to a ParkingSpotData repository entity.
     *
     * @param entity the ParkingSpot domain entity to convert
     * @return the converted ParkingSpotData repository entity
     */
    ParkingSpotData toRepositoryEntity(ParkingSpot entity);
}