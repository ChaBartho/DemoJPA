package org.example.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "product_id")
    private long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "quantity_per_unit")
    private String qttPerUnit;

    @Column(name = "units_in_stock")
    private int stock;

    @Column(name = "units_on_order")
    private int onOrder;

    @Column(name = "reorder_level")
    private int reorderLevel;

    private int discontinued;




    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
