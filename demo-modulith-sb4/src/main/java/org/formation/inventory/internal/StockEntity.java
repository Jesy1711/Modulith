package org.formation.inventory.internal;

import jakarta.persistence.*;

@Entity
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long coffeeId;
    private int quantity;


    protected StockEntity() {}

    public StockEntity(Long coffeeId, int quantity) {
        this.coffeeId = coffeeId;
        this.quantity = quantity;
    }

    public Long getCoffeeId() { return coffeeId; }
}
