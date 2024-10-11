package com.grupo7.parkingmeter.infra.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
@Table(name = "parking_spots")
public class ParkingSpotData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;  // CEP como chave primária
    private String location;  // Exemplo: número da vaga ou nome da área
    private String logradouro;  // Rua (Logradouro)
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private int quantity;
}