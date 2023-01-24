package org.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.entities.Category;
import org.example.entities.Product;
import org.example.entities.Supplier;
import org.example.repository.ProductRepository;
import org.example.repository.SupplierRepository;
import org.example.repository.impl.ProductRepositoryImpl;
import org.example.repository.impl.SupplierRepositoryImpl;
import org.example.utils.EMFSharer;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepositoryImpl();
        SupplierRepository supplierRepository = new SupplierRepositoryImpl();
/*
//Get all
        List<Product> products = productRepository.getUnitPriceBetween(1,10);
        products.forEach( p -> System.out.printf("- [%d] %s: %f$\n", p.getName(), p.getUnitPrice()) );

//Update
        Product product = products.get(0);
        product.setUnitPrice( 11. );
        productRepository.update( product.getId(), product );
*/

//Delete
        productRepository.remove(78L);
        List<Product> products = productRepository.getUnitPriceBetween(1,10);
        products.forEach( p -> System.out.printf("- [%d] %s: %f$\n", p.getName(), p.getUnitPrice()) );


//Add
        Product p = productRepository.get(1L)
                        .orElseThrow();
        System.out.printf( "- [%d] %s: %f$\n", p.getName(), p.getUnitPrice() );
        p.setId(90);
        p.setName(p.getName() + " - copy");
        productRepository.add( p );




        List<Supplier> suppliers = supplierRepository.getSupplierByRegion("Oh la belle région !");
        suppliers.forEach( sup -> System.out.println("meh"));





        EMFSharer.getInstance().close();
    }
}

/*        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("northwind");

        EntityManager em = emf.createEntityManager();


  -> se retrouve dans le repository (ProductRepositoryImpl)
        //GET ONE
        Product product = em.find( Product.class, 1L);      //renvoie une entité qui est managée
        System.out.println( product.getName() );
        System.out.println( product.getCategory().getCategoryName() );
        System.out.println( product.getSupplier().getCompanyName() );
        em.detach( product );    //detach = l'inverse de merge


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



        emf.close();
 */