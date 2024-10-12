package com.grupo7.parkingmeter.service;

import com.grupo7.parkingmeter.model.TicketRequest;
import com.grupo7.parkingmeter.model.TicketResponse;

public interface TicketService {
    TicketResponse create(TicketRequest ticketRequest);
}
