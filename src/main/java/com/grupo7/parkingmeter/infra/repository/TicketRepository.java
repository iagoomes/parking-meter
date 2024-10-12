package com.grupo7.parkingmeter.infra.repository;

import com.grupo7.parkingmeter.infra.repository.model.TicketData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;


@Repository
public interface TicketRepository extends JpaRepository<TicketData, Long> {

    // Conta tickets válidos, ou seja, com validUntil maior que o momento atual
    @Query("SELECT COUNT(t) FROM TicketData t WHERE t.parkingSpotData.id = :parkingSpotId AND t.validUntil > :currentTime")
    long countValidTickets(@Param("parkingSpotId") Long parkingSpotId, @Param("currentTime") OffsetDateTime currentTime);

    @Query("SELECT COUNT(t) FROM TicketData t WHERE t.licensePlate = :licensePlate AND t.validUntil > :currentTime")
    long countValidTicketsByLicensePlate(@Param("licensePlate") String licensePlate, @Param("currentTime") OffsetDateTime currentTime);
}
