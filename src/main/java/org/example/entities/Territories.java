package org.example.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "territories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Territories {

    @Id
    @Column(name = "territory_id")
    private String id;

    @Column(name = "territory_description")
    private String desc;


    @ManyToOne
    @JoinColumn(name = "territories")
    private Region regId;

    @ManyToMany(mappedBy = "territories")
    private Set<Employee> employees = new LinkedHashSet<>();



}
