package org.example.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@Entity
@Table(name = "customer_demographics")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Demographics {

    @Id
    @Column(name = "customer_type_id")
    private long id;

    @Column(name = "customer_desc")
    private String desc;



    //L'entité faible possède la mappedBy
    @ManyToMany(mappedBy = "types")
    private List<Customer> customers;



}
