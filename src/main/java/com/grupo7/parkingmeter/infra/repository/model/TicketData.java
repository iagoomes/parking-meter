package com.grupo7.parkingmeter.infra.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "tickets")
public class TicketData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "parking_spot_id", nullable = false)
    private ParkingSpotData parkingSpotData;
    private OffsetDateTime purchasedAt;
    private OffsetDateTime validUntil;
    private String licensePlate;
}