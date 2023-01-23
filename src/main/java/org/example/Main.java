package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.entities.Category;
import org.example.entities.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("northwind");

        EntityManager em = emf.createEntityManager();


        //GET ONE
        Product product = em.find( Product.class, 33L);      //renvoie une entité qui est attachée
        System.out.println( product.getName() );
        System.out.println( product.getCategory().getCategoryName() );
        System.out.println( product.getSupplier().getContactName() );

/*
        //GET ALL
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> list = query.getResultList();
        list.forEach( p -> System.out.println(p.getName()) );


        //UPDATE
        em.getTransaction().begin();
        product.setQttPerUnit("300g");
        em.getTransaction().commit();


        //INSERT
        Category cat = new Category();
        cat.setId( (short)19 );
        cat.setCategoryName("Other");
        cat.setDescription("Products with default category");

        em.getTransaction().begin();
        em.persist( cat );      // si id != des id déjà présent, sinon exception // que insertion sinon crash
        em.merge( cat );        // si id != des id déjà présent, sinon update // insertion ou update en fonction de l'id
        em.getTransaction().commit();



        //DELETE
        // soit par id soit par entités déjà attachées
        em.getTransaction().begin();
        em.merge( cat );    //je réattache une entité qui est détachée
        em.remove( cat );
        em.getTransaction().commit();

*/







        emf.close();
    }
}