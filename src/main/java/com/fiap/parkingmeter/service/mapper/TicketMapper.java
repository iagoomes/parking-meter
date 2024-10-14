package com.fiap.parkingmeter.service.mapper;

import com.fiap.parkingmeter.model.TicketRequest;
import com.fiap.parkingmeter.model.TicketResponse;
import com.fiap.parkingmeter.provider.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.OffsetDateTime;

/**
 * Mapper interface for converting between Ticket entity and its corresponding DTOs.
 * Utilizes MapStruct for automatic mapping.
 */
@Mapper(componentModel = "spring", imports = {OffsetDateTime.class})
public interface TicketMapper {

    /**
     * Converts a Ticket entity to a TicketResponse DTO.
     *
     * @param ticket the Ticket entity to convert
     * @return the converted TicketResponse DTO
     */
    TicketResponse toDTO(Ticket ticket);

    /**
     * Converts a TicketRequest DTO to a Ticket entity.
     * Sets the current time for purchasedAt and calculates validUntil based on the hours provided.
     *
     * @param ticketRequest the TicketRequest DTO to convert
     * @return the converted Ticket entity
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parkingSpotId", source = "parkingSpotId")
    @Mapping(target = "purchasedAt", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "validUntil", expression = "java(OffsetDateTime.now().plusHours(ticketRequest.getHours()))")
    Ticket toUseCaseData(TicketRequest ticketRequest);
}