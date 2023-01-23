package org.example.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
    @ManyToOne
    @JoinColumn(name = "ship_via")
    private Shipper shipVia;
    @Column(name = "freight")
    private float freight;
    @Column(name = "ship_name")
    private String shipName;
    @Column(name = "ship_address")
    private String shipAddress;
    @Column(name = "ship_city")
    private String shipCity;
    @Column(name = "ship_region")
    private String shipRegion;
    @Column(name = "ship_postal_code")
    private String shipPostalCode;
    @Column(name = "ship_country")
    private String shipCountry;


    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee managedBy;



}
