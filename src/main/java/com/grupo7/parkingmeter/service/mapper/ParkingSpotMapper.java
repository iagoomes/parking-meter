package com.grupo7.parkingmeter.service.mapper;

import com.grupo7.parkingmeter.model.ParkingSpotRequest;
import com.grupo7.parkingmeter.model.ParkingSpotResponse;
import com.grupo7.parkingmeter.provider.entity.ParkingSpot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParkingSpotMapper {

    ParkingSpotResponse toDTO(ParkingSpot parkingSpot);

    ParkingSpot toUseCaseData(ParkingSpotRequest parkingSpotRequest);
}
