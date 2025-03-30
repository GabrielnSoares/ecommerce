package br.gabnsoares.dev.ecommerce.controller.dto;

import java.util.List;
import java.util.UUID;

public record CreateOrderDto(UUID userId, List<OrderItemDto> items) {
    public CreateOrderDto(UUID userId, List<OrderItemDto> items) {
        this.userId = userId;
        this.items = (items != null) ? items : List.of(); // Evita null
    }
}

