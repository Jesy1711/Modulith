package org.formation.catalog;

import org.formation.catalog.internal.CoffeeEntity;
import org.formation.catalog.internal.CoffeeRespository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Catalog {
    private final CoffeeRespository respository;
    private final ApplicationEventPublisher events;

    public Catalog(CoffeeRespository respository, ApplicationEventPublisher events) {
        this.respository = respository;
        this.events = events;
    }

    @Transactional
    public Long createCoffee(String name, int price) {
        CoffeeEntity saved  = respository.save(new CoffeeEntity(name, price));
        events.publishEvent(new CoffeCreated(saved.getId(), saved.getName()));
        return saved.getId();
    }
}
