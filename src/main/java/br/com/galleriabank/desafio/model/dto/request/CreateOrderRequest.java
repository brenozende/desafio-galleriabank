package br.com.galleriabank.desafio.model.dto.request;

import lombok.Data;

import java.util.List;

public record CreateOrderRequest (
    Long clientId,
    List<Long> products,
    String description
) {}
