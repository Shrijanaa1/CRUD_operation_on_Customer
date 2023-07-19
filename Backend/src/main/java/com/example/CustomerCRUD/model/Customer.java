package com.example.CustomerCRUD.model;

import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String fname;

    @Column(name = "last_name")
    private String lname;


//    @NotEmpty(message = "Email is required")
//    @Email(message = "Email should be valid")
    private String email;
    private String password;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "customer_images",
//        joinColumns = {
//                @JoinColumn(name = "customer_id")
//        },
//        inverseJoinColumns = {
//                @JoinColumn(name = "image_id")
//        }
//    )
//    private Set<ImageModel> customerImages;

}
