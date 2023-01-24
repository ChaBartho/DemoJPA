package org.example.repository;

import org.example.entities.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>{
        // 1) implements CrudRepository = implémentaion des méthodes par défaut
        // 2) Choisir une méthode propre à mon interface -> Product

    List<Product> getUnitPriceBetween(double min, double max);


}
