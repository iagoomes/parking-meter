package com.fiap.parkingmeter.resource;

import com.fiap.parkingmeter.api.TicketApiDelegate;
import com.fiap.parkingmeter.model.TicketRequest;
import com.fiap.parkingmeter.model.TicketResponse;
import com.fiap.parkingmeter.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * Resource class for managing parking tickets in the resource layer.
 */
@Component
@RequiredArgsConstructor
public class TicketResource implements TicketApiDelegate {

    private final TicketService ticketService;

    /**
     * Creates a new parking ticket.
     *
     * @param ticketRequest the ticket data to create
     * @return a CompletableFuture containing a ResponseEntity with the created ticket
     */
    @Override
    public CompletableFuture<ResponseEntity<TicketResponse>> createTicket(TicketRequest ticketRequest) {
        return CompletableFuture.supplyAsync(
                () -> ResponseEntity.ok().body(
                        ticketService.create(ticketRequest)));
    }
}