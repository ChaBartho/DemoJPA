package org.example.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// = table intermédiaire
@Entity
@Table(name = "order_details")
@Getter @Setter
public class OrderDetail {

    @Id
    @EmbeddedId // permet qu'un classe embeddable puisse fonctionner en tant qu'ID
    private OrderDetailID id;

    @MapsId("productId")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @MapsId("orderId")
    @ManyToOne
    @JoinColumn(name = "order_id")  // = nom de la var à l'intérieur de l'ID qui fait référence à cette colonne
    private Order order;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "quantity")
    private int qtt;

    private double discount;

}
