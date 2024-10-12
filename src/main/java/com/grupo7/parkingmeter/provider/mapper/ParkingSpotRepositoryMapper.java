package com.grupo7.parkingmeter.provider.mapper;

import com.grupo7.parkingmeter.infra.repository.model.ParkingSpotData;
import com.grupo7.parkingmeter.provider.entity.ParkingSpot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParkingSpotRepositoryMapper {
    ParkingSpot toDomain(ParkingSpotData parkingSpotData);

    ParkingSpotData toEntityRepository(ParkingSpot entity);
}
