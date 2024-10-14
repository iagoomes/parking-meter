package com.fiap.parkingmeter.service;

import com.fiap.parkingmeter.model.TicketRequest;
import com.fiap.parkingmeter.model.TicketResponse;

/**
 * Service interface for managing parking tickets.
 */
public interface TicketService {

    /**
     * Creates a new parking ticket.
     *
     * @param ticketRequest the ticket data to create
     * @return the created ticket
     */
    TicketResponse create(TicketRequest ticketRequest);
}