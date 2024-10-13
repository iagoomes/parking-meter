package com.grupo7.parkingmeter.usecase;

import com.grupo7.parkingmeter.provider.TicketProvider;
import com.grupo7.parkingmeter.provider.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Use case class for managing parking tickets.
 */
@Service
@RequiredArgsConstructor
public class TicketUseCase {
    private final TicketProvider ticketProvider;

    /**
     * Creates a new parking ticket.
     *
     * @param useCaseData the ticket data to create
     * @return the created ticket
     */
    public Ticket create(Ticket useCaseData) {
        return ticketProvider.create(useCaseData);
    }
}