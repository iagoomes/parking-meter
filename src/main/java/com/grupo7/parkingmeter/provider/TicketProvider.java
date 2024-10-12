package com.grupo7.parkingmeter.provider;

import com.grupo7.parkingmeter.infra.exception.BusinessException;
import com.grupo7.parkingmeter.infra.repository.TicketRepository;
import com.grupo7.parkingmeter.infra.repository.model.TicketData;
import com.grupo7.parkingmeter.provider.entity.ParkingSpot;
import com.grupo7.parkingmeter.provider.entity.Ticket;
import com.grupo7.parkingmeter.provider.mapper.ParkingSpotRepositoryMapper;
import com.grupo7.parkingmeter.provider.mapper.TicketRepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class TicketProvider {
    private final TicketRepository ticketRepository;
    private final ParkingSpotProvider parkingSpotProvider;
    private final TicketRepositoryMapper ticketRepositoryMapper;
    private final ParkingSpotRepositoryMapper parkingSpotRepositoryMapper;

    public Ticket create(Ticket ticket) {
        ParkingSpot parkingSpot = parkingSpotProvider.findById(ticket.getParkingSpotId());
        validateActiveTicketForLicensePlate(ticket.getLicensePlate());
        validateAvailableSpots(ticket.getParkingSpotId(), parkingSpot.getQuantity());

        TicketData newTicket = ticketRepositoryMapper.toRepositoryEntity(ticket);
        newTicket.setParkingSpotData(parkingSpotRepositoryMapper.toRepositoryEntity(parkingSpot));

        return ticketRepositoryMapper.toDomain(ticketRepository.save(newTicket));
    }

    private void validateActiveTicketForLicensePlate(String licensePlate) {
        long activeTickets = ticketRepository.countValidTicketsByLicensePlate(licensePlate, OffsetDateTime.now());
        if (activeTickets > 0) {
            throw new BusinessException("Já existe um ticket ativo para este veículo.");
        }
    }

    private void validateAvailableSpots(Long parkingSpotId, int maxSpots) {
        long validTickets = ticketRepository.countValidTickets(parkingSpotId, OffsetDateTime.now());
        if (validTickets >= maxSpots) {
            throw new BusinessException("Não há vagas disponíveis no momento.");
        }
    }

}