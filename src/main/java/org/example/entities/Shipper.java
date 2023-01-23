package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "shippers")
@Getter @Setter
public class Shipper {
    @Id
    @Column(name = "shipper_id")
    private Short id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone", length = 24)
    private String phone;

    @OneToMany(mappedBy = "shipVia")
    private Set<Order> orders;

}   //toMany = list  - toOne = un seul élément
