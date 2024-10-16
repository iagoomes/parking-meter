package com.fiap.parkingmeter.provider;

import com.fiap.parkingmeter.infra.exception.BusinessException;
import com.fiap.parkingmeter.infra.repository.TicketRepository;
import com.fiap.parkingmeter.infra.repository.model.TicketData;
import com.fiap.parkingmeter.provider.entity.ParkingSpot;
import com.fiap.parkingmeter.provider.entity.Ticket;
import com.fiap.parkingmeter.provider.mapper.ParkingSpotRepositoryMapper;
import com.fiap.parkingmeter.provider.mapper.TicketRepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

/**
 * Provider class for managing parking tickets in the provider layer.
 */
@Component
@RequiredArgsConstructor
public class TicketProvider {
    private final TicketRepository ticketRepository;
    private final ParkingSpotProvider parkingSpotProvider;
    private final TicketRepositoryMapper ticketRepositoryMapper;
    private final ParkingSpotRepositoryMapper parkingSpotRepositoryMapper;

    /**
     * Creates a new parking ticket.
     *
     * @param ticket the ticket to create
     * @return the created ticket
     */
    public Ticket create(Ticket ticket) {
        ParkingSpot parkingSpot = parkingSpotProvider.findById(ticket.getParkingSpotId());
        validateActiveTicketForLicensePlate(ticket.getLicensePlate());
        validateAvailableSpots(ticket.getParkingSpotId(), parkingSpot.getQuantity());

        TicketData newTicket = ticketRepositoryMapper.toRepositoryEntity(ticket);
        newTicket.setParkingSpotData(parkingSpotRepositoryMapper.toRepositoryEntity(parkingSpot));

        return ticketRepositoryMapper.toDomain(ticketRepository.save(newTicket));
    }

    /**
     * Validates if there is an active ticket for the given license plate.
     *
     * @param licensePlate the license plate to check
     * @throws BusinessException if there is an active ticket for the license plate
     */
    private void validateActiveTicketForLicensePlate(String licensePlate) {
        long activeTickets = ticketRepository.countValidTicketsByLicensePlate(licensePlate, OffsetDateTime.now());
        if (activeTickets > 0) {
            throw new BusinessException("There is already an active ticket for this vehicle.", HttpStatus.CONFLICT);
        }
    }

    /**
     * Validates if there are available spots for the given parking spot ID.
     *
     * @param parkingSpotId the parking spot ID to check
     * @param maxSpots the maximum number of spots available
     * @throws BusinessException if there are no available spots
     */
    private void validateAvailableSpots(Long parkingSpotId, int maxSpots) {
        long validTickets = ticketRepository.countValidTickets(parkingSpotId, OffsetDateTime.now());
        if (validTickets >= maxSpots) {
            throw new BusinessException("No available spots at the moment.", HttpStatus.CONFLICT);
        }
    }

}