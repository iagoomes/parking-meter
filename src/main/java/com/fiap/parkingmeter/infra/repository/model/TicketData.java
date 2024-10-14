package com.fiap.parkingmeter.infra.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * Entity representing a parking ticket.
 */
@Data
@Entity
@Table(name = "tickets")
public class TicketData {

    /**
     * Unique identifier for the ticket.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The parking spot associated with this ticket.
     */
    @ManyToOne
    @JoinColumn(name = "parking_spot_id", nullable = false)
    private ParkingSpotData parkingSpotData;

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