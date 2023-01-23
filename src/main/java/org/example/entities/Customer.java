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
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer{

    @Id
    @Column(name = "customer_id")
    private long id;

    @Column(name = "company_name")
    private String company;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_title")
    private String contactTitle;

    private String address;

    private String city;

    private String region;

    @Column(name = "postal_code")
    private String postalCode;

    private String country;

    private String phone;

    private String fax;



    @ManyToMany
    @JoinTable(
            name = "customer_customer_demo",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_type_id")
    )
    private List<Demographics> types;

    @OneToMany(mappedBy = "managedBy")
    private Set<Order> orders = new LinkedHashSet<>();
}
