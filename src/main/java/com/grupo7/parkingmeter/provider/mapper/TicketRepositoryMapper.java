package com.grupo7.parkingmeter.provider.mapper;

import com.grupo7.parkingmeter.infra.repository.model.TicketData;
import com.grupo7.parkingmeter.provider.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketRepositoryMapper {
    @Mapping(target = "parkingSpotId", source = "parkingSpotData.id")
    Ticket toDomain(TicketData ticketData);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parkingSpotData", ignore = true)
    TicketData toRepositoryEntity(Ticket ticket);
}
