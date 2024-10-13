package com.grupo7.parkingmeter.provider.entity;

import lombok.Data;

import java.time.OffsetDateTime;

/**
 * Entity representing a parking ticket in the provider layer.
 */
@Data
public class Ticket {

    /**
     * Unique identifier for the ticket.
     */
    private Long id;

    /**
     * The ID of the parking spot associated with this ticket.
     */
    private Long parkingSpotId;

    /**
     * The date and time when the ticket was purchased.
     */
    private OffsetDateTime purchasedAt;

    /**
     * The date and time until the ticket is valid.
     */
    private OffsetDateTime validUntil;

    /**
     * The license plate of the vehicle associated with this ticket.
     */
    private String licensePlate;
}