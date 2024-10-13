package com.grupo7.parkingmeter.service.impl;

import com.grupo7.parkingmeter.infra.exception.BusinessException;
import com.grupo7.parkingmeter.model.TicketRequest;
import com.grupo7.parkingmeter.model.TicketResponse;
import com.grupo7.parkingmeter.service.TicketService;
import com.grupo7.parkingmeter.service.mapper.TicketMapper;
import com.grupo7.parkingmeter.usecase.TicketUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation for managing parking tickets.
 */
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketUseCase ticketUseCase;
    private final TicketMapper ticketMapper;

    /**
     * Creates a new parking ticket.
     *
     * @param ticketRequest the ticket data to create
     * @return the created ticket
     * @throws BusinessException if the ticket duration is invalid
     */
    @Override
    public TicketResponse create(TicketRequest ticketRequest) {
        if (ticketRequest.getHours() > 3) {
            throw new BusinessException("O ticket não pode ser emitido para mais de 3 horas.");
        }
        if (ticketRequest.getHours() <= 0) {
            throw new BusinessException("O ticket não pode ser emitido por menos de 1 hora.");
        }

        return ticketMapper.toDTO(ticketUseCase.create(ticketMapper.toUseCaseData(ticketRequest)));
    }

}