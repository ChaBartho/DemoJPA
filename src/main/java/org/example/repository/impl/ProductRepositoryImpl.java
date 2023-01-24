package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.example.entities.Product;
import org.example.repository.ProductRepository;
import org.example.utils.EMFSharer;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

//EntityManager sert à opérer des actions dans les DB
    private final EntityManager manager = EMFSharer.getInstance()
            .createEntityManager();


//Add:
    @Override
    public void add(Product toInsert) {
        manager.getTransaction().begin();
        manager.persist( toInsert );
        manager.getTransaction().commit();
    }

//Get one:
    @Override
    public Optional<Product> get(Long id) {
        Product p = manager.find(Product.class, id);
        manager.clear();
        return Optional.ofNullable( p );
    }

//Get all:
    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = manager.createQuery("SELECT prod FROM Product prod", Product.class);
        List<Product> products = query.getResultList();
        manager.clear();
        return products;
    }

//Update:
    @Override
    public void update(Long id, Product entity) {
        entity.setId( id );

        // SELECT COUNT(*) FROM product WHERE product_id = ?
        String qlQuery = "SELECT COUNT(p) FROM Product p WHERE p.id = ?1";
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

        Product product = manager.find(Product.class, id);
        if( product != null )
            manager.remove( product );

        manager.getTransaction().commit();
    }







    @Override
    public List<Product> getUnitPriceBetween(double min, double max) {
        //SELECT * FROM product WHERE unit_price BETWEEN ? AND ?
        String qlQuery = "SELECT p FROM Product p WHERE p.unitPrice BETWEEN ?1 AND ?2";
        TypedQuery<Product> query = manager.createQuery(qlQuery, Product.class);
        query.setParameter(1, min);
        query.setParameter(2, max);

        List<Product> products = query.getResultList();
        manager.clear();
        return products;
    }




}