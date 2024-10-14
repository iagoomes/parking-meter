package com.fiap.parkingmeter.usecase;

import com.fiap.parkingmeter.provider.TicketProvider;
import com.fiap.parkingmeter.provider.entity.Ticket;
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