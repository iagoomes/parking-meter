package com.grupo7.parkingmeter.provider.entity;

import lombok.Data;

@Data
public class ParkingSpot {
    private String cep;
    private String location;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private int quantity;
}
