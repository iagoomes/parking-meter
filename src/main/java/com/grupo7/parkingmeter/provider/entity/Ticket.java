package com.grupo7.parkingmeter.provider.entity;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Ticket {
    private Long id;
    private Long parkingSpotId;
    private OffsetDateTime purchasedAt;
    private OffsetDateTime validUntil;
    private String licensePlate;
}
