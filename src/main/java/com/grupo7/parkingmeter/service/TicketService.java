package com.grupo7.parkingmeter.service;

import com.grupo7.parkingmeter.model.TicketRequest;
import com.grupo7.parkingmeter.model.TicketResponse;

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