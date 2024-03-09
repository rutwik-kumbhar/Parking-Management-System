package com.parking.ParkingManagementBackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parking.ParkingManagementBackend.types.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehicleId;

    private  String vehicleName;

    private String model;

    private  String number;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime parkDateAndTime;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;


    @ManyToOne()
    @JoinColumn(name = "floor_id")
    private Floor floor;
}
