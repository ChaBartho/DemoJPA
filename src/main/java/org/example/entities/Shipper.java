package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "shippers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shipper {

    @Id
    @Column(name = "shipper_id")
    private long id;







    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Order> orders;

    //toMany = list  - toOne = un seul élément
}
