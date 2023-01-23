package org.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "us_states")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsStates {

    @Id
    @Column(name = "state_id")
    private long id;

    @Column(name = "state_name")
    private String name;

    @Column(name = "State_abbr")
    private String abbr;

    @Column(name = "state_region")
    private String stateReg;



}
