package br.com.galleriabank.desafio.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    private Long clientId;
    private List<Long> products;
}
