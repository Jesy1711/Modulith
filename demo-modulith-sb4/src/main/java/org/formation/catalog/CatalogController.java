package org.formation.catalog;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coffees")
class CatalogController {

    private final Catalog catalog;

    CatalogController(Catalog catalog) {
        this.catalog = catalog;
    }

    @PostMapping
    Long create(@RequestParam String name, @RequestParam int price) {
        return catalog.createCoffee(name, price);
    }
}
