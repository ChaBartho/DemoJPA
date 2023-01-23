package org.example.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@Entity
@Table(name = "suppliers")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @Column(name ="supplier_id")
    private long id;

    private String homepage;








    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    //toMany = list  - toOne = un seul élément
}
