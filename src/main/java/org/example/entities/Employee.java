package org.example.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @Column(name = "employee_id")
    private long id;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "title")
    private String title;
    @Column(name = "title_of_courtesy")
    private String courtesy;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "hire_date")
    private LocalDate hireDate;
    private String address;
    private String city;
    private String region;
    @Column(name = "postal_code")
    private String postalCode;
    private String country;
    @Column(name = "home_phone")
    private String homePhone;
    private String extension;
    private String note;
    @ManyToOne
    @JoinColumn(name = "reports_to")
    private Employee reportsTo;

    @OneToMany(mappedBy = "reportsTo")
    private Set<Employee> subordinates;

    @Column(name = "photo_path")
    private String photoPath;


    @ManyToMany
    @JoinTable(
            name = "employee_territories",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "territory_id")
    )
    private Set<Territories> territories = new LinkedHashSet<>();
    @OneToMany(mappedBy = "managedBy")
    private Set<Order> orders = new LinkedHashSet<>();
}
