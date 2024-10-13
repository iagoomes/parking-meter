package com.grupo7.parkingmeter.infra.repository;

import com.grupo7.parkingmeter.infra.repository.model.TicketData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

/**
 * Repository interface for managing TicketData entities.
 */
@Repository
public interface TicketRepository extends JpaRepository<TicketData, Long> {

    /**
     * Counts the number of valid tickets for a given parking spot.
     * A ticket is considered valid if its validUntil time is greater than the current time.
     *
     * @param parkingSpotId the ID of the parking spot
     * @param currentTime the current time
     * @return the number of valid tickets
     */
    @Query("SELECT COUNT(t) FROM TicketData t WHERE t.parkingSpotData.id = :parkingSpotId AND t.validUntil > :currentTime")
    long countValidTickets(@Param("parkingSpotId") Long parkingSpotId, @Param("currentTime") OffsetDateTime currentTime);

    /**
     * Counts the number of valid tickets for a given license plate.
     * A ticket is considered valid if its validUntil time is greater than the current time.
     *
     * @param licensePlate the license plate of the vehicle
     * @param currentTime the current time
     * @return the number of valid tickets
     */
    @Query("SELECT COUNT(t) FROM TicketData t WHERE t.licensePlate = :licensePlate AND t.validUntil > :currentTime")
    long countValidTicketsByLicensePlate(@Param("licensePlate") String licensePlate, @Param("currentTime") OffsetDateTime currentTime);
}