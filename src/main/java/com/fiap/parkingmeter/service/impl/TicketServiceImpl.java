package com.fiap.parkingmeter.service.impl;

import com.fiap.parkingmeter.infra.exception.BusinessException;
import com.fiap.parkingmeter.model.TicketRequest;
import com.fiap.parkingmeter.model.TicketResponse;
import com.fiap.parkingmeter.service.TicketService;
import com.fiap.parkingmeter.service.mapper.TicketMapper;
import com.fiap.parkingmeter.usecase.TicketUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
            throw new BusinessException("O ticket não pode ser emitido para mais de 3 horas.", HttpStatus.BAD_REQUEST);
        }
        if (ticketRequest.getHours() <= 0) {
            throw new BusinessException("O ticket não pode ser emitido por menos de 1 hora.", HttpStatus.BAD_REQUEST);
        }

        return ticketMapper.toDTO(ticketUseCase.create(ticketMapper.toUseCaseData(ticketRequest)));
    }

}