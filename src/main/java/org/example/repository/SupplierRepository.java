package org.example.repository;

import org.example.entities.Supplier;

import java.util.List;
public interface SupplierRepository extends CrudRepository<Supplier, Long>{
    // 1) implements CrudRepository = implémentaion des méthodes par défaut
    // 2) Choisir une méthode propre à mon interface -> Supplier

    List<Supplier> getSupplierByRegion(String region);
    void rajoutVip (String rajout, String city);


}
