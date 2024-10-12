package com.grupo7.parkingmeter.provider;

import com.grupo7.parkingmeter.infra.exception.BusinessException;
import com.grupo7.parkingmeter.infra.exception.ControllerNotFoundException;
import com.grupo7.parkingmeter.infra.repository.ParkingSpotRepository;
import com.grupo7.parkingmeter.infra.repository.TicketRepository;
import com.grupo7.parkingmeter.infra.repository.model.ParkingSpotData;
import com.grupo7.parkingmeter.provider.mapper.ParkingSpotRepositoryMapper;
import com.grupo7.parkingmeter.provider.entity.ParkingSpot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ParkingSpotProvider {
    private final ParkingSpotRepository parkingSpotRepository;
    private final TicketRepository ticketRepository;
    private final ParkingSpotRepositoryMapper mapper;

    public List<ParkingSpot> findAll() {
        return parkingSpotRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    public ParkingSpot findById(Long id) {
        Optional<ParkingSpotData> parkingSpotDataOptional = parkingSpotRepository.findById(id);
        return mapper.toDomain(
                parkingSpotDataOptional.orElseThrow(() -> new ControllerNotFoundException("Parking spot not found."))
        );
    }

    public ParkingSpot findByCep(String cep) {
        Optional<ParkingSpotData> parkingSpotDataOptional = parkingSpotRepository.findByCep(cep);
        return mapper.toDomain(
                parkingSpotDataOptional.orElseThrow(() -> new ControllerNotFoundException("Parking spot not found."))
        );
    }

    public String create(ParkingSpot useCaseData) {
        ParkingSpotData domain = mapper.toEntityRepository(useCaseData);
        return parkingSpotRepository.save(domain).getId().toString();
    }

    public ParkingSpot update(Long id, ParkingSpot useCaseData) {
        if (!parkingSpotRepository.existsById(id)) {
            throw new BusinessException("Parking spot not found.");
        }

        ParkingSpotData domain = mapper.toEntityRepository(useCaseData);
        domain.setId(id);
        return mapper.toDomain(parkingSpotRepository.save(domain));
    }

    public void delete(Long id) {
        if (!parkingSpotRepository.existsById(id)) {
            throw new BusinessException("Parking spot not found.");
        }

        parkingSpotRepository.deleteById(id);
    }

}
