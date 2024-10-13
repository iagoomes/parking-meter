package com.grupo7.parkingmeter.provider.mapper;

import com.grupo7.parkingmeter.infra.repository.model.TicketData;
import com.grupo7.parkingmeter.provider.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper interface for converting between Ticket domain entities and TicketData repository entities.
 */
@Mapper(componentModel = "spring")
public interface TicketRepositoryMapper {

    /**
     * Converts a TicketData repository entity to a Ticket domain entity.
     *
     * @param ticketData the TicketData entity to convert
     * @return the converted Ticket domain entity
     */
    @Mapping(target = "parkingSpotId", source = "parkingSpotData.id")
    Ticket toDomain(TicketData ticketData);

    /**
     * Converts a Ticket domain entity to a TicketData repository entity.
     *
     * @param ticket the Ticket domain entity to convert
     * @return the converted TicketData repository entity
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parkingSpotData", ignore = true)
    TicketData toRepositoryEntity(Ticket ticket);
}