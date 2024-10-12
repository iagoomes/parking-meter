package com.grupo7.parkingmeter.resource;

import com.grupo7.parkingmeter.api.TicketApiDelegate;
import com.grupo7.parkingmeter.model.TicketRequest;
import com.grupo7.parkingmeter.model.TicketResponse;
import com.grupo7.parkingmeter.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class TicketResource implements TicketApiDelegate {

    private final TicketService ticketService;

    @Override
    public CompletableFuture<ResponseEntity<TicketResponse>> createTicket(TicketRequest ticketRequest) {
        return CompletableFuture.supplyAsync(
                () -> ResponseEntity.ok().body(
                        ticketService.create(ticketRequest)));
    }
}
