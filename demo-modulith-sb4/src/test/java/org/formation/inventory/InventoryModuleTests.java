package org.formation.inventory;

import org.formation.catalog.CoffeCreated;
import org.formation.inventory.internal.StockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
class InventoryModuleTests {

    @Autowired
    StockRepository stockRepository;

    @Test
    void createsStockOnCoffeeCreated(Scenario scenario) {
        scenario.publish(new CoffeCreated(1L, "Expresso"))
                .andWaitForStateChange(() -> stockRepository.findAll())
                .andVerify(stocks -> assertThat(stocks).hasSize(1));
    }
}
