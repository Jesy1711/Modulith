package org.formation.catalog.internal;

import jakarta.persistence.*;

@Entity
public class CoffeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int price;

    protected CoffeeEntity() {}

    public CoffeeEntity(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}
