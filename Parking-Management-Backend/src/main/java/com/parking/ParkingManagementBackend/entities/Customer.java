package com.parking.ParkingManagementBackend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name =  "customers")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;


    private String mobileNumber;


    @OneToMany(mappedBy =  "customer" , cascade = CascadeType.ALL)
    private final List<Vehicle> vehicles = new ArrayList<>();




}
