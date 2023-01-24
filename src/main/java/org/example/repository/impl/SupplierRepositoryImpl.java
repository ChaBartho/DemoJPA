package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Product;
import org.example.entities.Supplier;
import org.example.repository.SupplierRepository;
import org.example.utils.EMFSharer;

import java.util.List;
import java.util.Optional;

public class SupplierRepositoryImpl implements SupplierRepository {

    private final EntityManager manager = EMFSharer.getInstance()
            .createEntityManager();


//Add:
    @Override
    public void add(Supplier toInsert) {
        manager.getTransaction().begin();
        manager.persist( toInsert );
        manager.getTransaction().commit();
    }


//Get one:
    @Override
    public Optional<Supplier> get(Long id) {
        Supplier sup = manager.find(Supplier.class, id);
        manager.clear();
        return Optional.ofNullable( sup );
    }


//Get All:
    @Override
    public List<Supplier> getAll() {
        TypedQuery<Supplier> query = manager.createQuery("SELECT sup FROM Supplier sup", Supplier.class);
        List<Supplier> suppliers = query.getResultList();
        manager.clear();
        return suppliers;
    }


//Update:
    @Override
    public void update(Long id, Supplier entity) {
        entity.setId( id );

        // SELECT COUNT(*) FROM supplier WHERE supplier_id = ?
        String qlQuery = "SELECT COUNT(sup) FROM Supplier sup WHERE sup.id = ?1";
        TypedQuery<Long> countQuery = manager.createQuery(qlQuery, Long.class);

        countQuery.setParameter(1, id);
        Long count = countQuery.getSingleResult();

        if( count == 1 ) {
            manager.getTransaction().begin();
            manager.merge(entity);
            manager.getTransaction().commit();
        }
        else{
            throw new IllegalArgumentException("element does not exist");
        }
    }


//Delete:
    @Override
    public void remove(Long id) {
        manager.getTransaction().begin();

        Supplier sup = manager.find(Supplier.class, id);
        if( sup != null )
            manager.remove( sup );

        manager.getTransaction().commit();
    }






    @Override
    public List<Supplier> getSupplierByRegion(String region) {
        //SELECT * FROM supplier WHERE region
        String qlQuery = "SELECT sup FROM Supplier sup WHERE sup.region";
        TypedQuery<Supplier> query = manager.createQuery(qlQuery, Supplier.class);

        List<Supplier> suppliers = query.getResultList();
        manager.clear();
        return suppliers;
    }


    @Override
    public void rajoutVip(String rajout, String city) {

    }






}
