package org.example.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
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










    @ManyToMany
    @JoinTable(
            name = "customer_customer_demo",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_type_id")
    )
    private List<Demographics> types;

    //toMany = list  - toOne = un seul élément
}
