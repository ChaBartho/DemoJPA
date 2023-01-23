package org.example.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "order_id")
    private long id;

    @Column(name = "order_date")
    private LocalDate date;
    @Column(name = "required_date")
    private LocalDate requiredDate;
    @Column(name = "shipped_date")
    private LocalDate shippedDate;
    @Column(name = "ship_via")
    private int shipVia;
    private int freight;
    @Column(name = "ship_name")
    private String name;
    //...






    @ManyToMany
    @JoinColumn(name = "product_id")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier suppliers;
}
