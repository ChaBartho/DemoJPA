package org.example.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
@Entity
@Table(name = "region")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    @Column(name = "region_id")
    private long id;

    @Column(name = "region_description")
    private String regionDesc;


    @OneToMany(mappedBy = "regId")
    private Set<Territories> territories;


}
