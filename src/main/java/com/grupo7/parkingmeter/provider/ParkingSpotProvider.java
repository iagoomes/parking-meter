package com.grupo7.parkingmeter.provider;

import com.grupo7.parkingmeter.infra.exception.BusinessException;
import com.grupo7.parkingmeter.infra.repository.ParkingSpotRepository;
import com.grupo7.parkingmeter.infra.repository.model.ParkingSpotData;
import com.grupo7.parkingmeter.provider.entity.ParkingSpot;
import com.grupo7.parkingmeter.provider.mapper.ParkingSpotRepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Provider class for managing parking spots in the provider layer.
 */
@Component
@RequiredArgsConstructor
public class ParkingSpotProvider {
    private final ParkingSpotRepository parkingSpotRepository;
    private final ParkingSpotRepositoryMapper mapper;

    /**
     * Retrieves all parking spots.
     *
     * @return a list of all parking spots
     */
    public List<ParkingSpot> findAll() {
        return parkingSpotRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    /**
     * Retrieves a parking spot by its ID.
     *
     * @param id the ID of the parking spot
     * @return the parking spot with the given ID
     * @throws BusinessException if the parking spot is not found
     */
    public ParkingSpot findById(Long id) {
        Optional<ParkingSpotData> parkingSpotDataOptional = parkingSpotRepository.findById(id);
        return mapper.toDomain(
                parkingSpotDataOptional.orElseThrow(() -> new BusinessException("Parking spot not found.", HttpStatus.NOT_FOUND))
        );
    }

    /**
     * Retrieves a parking spot by its postal code (CEP).
     *
     * @param cep the postal code of the parking spot
     * @return the parking spot with the given postal code
     * @throws BusinessException if the parking spot is not found
     */
    public ParkingSpot findByCep(String cep) {
        Optional<ParkingSpotData> parkingSpotDataOptional = parkingSpotRepository.findByCep(cep);
        return mapper.toDomain(
                parkingSpotDataOptional.orElseThrow(() -> new BusinessException("Parking spot not found.", HttpStatus.NOT_FOUND))
        );
    }

    /**
     * Creates a new parking spot.
     *
     * @param useCaseData the parking spot data to create
     * @return the ID of the created parking spot
     * @throws BusinessException if a parking spot with the given CEP and location already exists
     */
    public String create(ParkingSpot useCaseData) {
        Optional<ParkingSpotData> existingSpot =
                parkingSpotRepository.findByCepAndLocation(useCaseData.getCep(), useCaseData.getLocation());
        if (existingSpot.isPresent()) {
            throw new BusinessException("Parking spot with the given CEP and location already exists.", HttpStatus.CONFLICT);
        }
        ParkingSpotData domain = mapper.toRepositoryEntity(useCaseData);
        return parkingSpotRepository.save(domain).getId().toString();
    }

    /**
     * Updates an existing parking spot.
     *
     * @param id          the ID of the parking spot to update
     * @param useCaseData the updated parking spot data
     * @return the updated parking spot
     * @throws BusinessException if the parking spot is not found
     */
    public ParkingSpot update(Long id, ParkingSpot useCaseData) {
        if (!parkingSpotRepository.existsById(id)) {
            throw new BusinessException("Parking spot not found.", HttpStatus.NOT_FOUND);
        }

        ParkingSpotData domain = mapper.toRepositoryEntity(useCaseData);
        domain.setId(id);
        return mapper.toDomain(parkingSpotRepository.save(domain));
    }

    /**
     * Deletes a parking spot by its ID.
     *
     * @param id the ID of the parking spot to delete
     * @throws BusinessException if the parking spot is not found
     */
    public void delete(Long id) {
        if (!parkingSpotRepository.existsById(id)) {
            throw new BusinessException("Parking spot not found.", HttpStatus.NOT_FOUND);
        }

        parkingSpotRepository.deleteById(id);
    }

}