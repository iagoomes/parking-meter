package com.grupo7.parkingmeter.usecase;

import com.grupo7.parkingmeter.provider.TicketProvider;
import com.grupo7.parkingmeter.provider.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketUseCase {
    private final TicketProvider ticketProvider;

    public Ticket create(Ticket useCaseData) {
        return ticketProvider.create(useCaseData);
    }
}
