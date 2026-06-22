package br.com.galleriabank.desafio.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {
    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;
}
