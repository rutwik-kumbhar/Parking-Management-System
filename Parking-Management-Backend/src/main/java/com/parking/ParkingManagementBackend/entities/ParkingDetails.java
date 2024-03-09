package com.parking.ParkingManagementBackend.entities;

import com.parking.ParkingManagementBackend.types.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.BindParam;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ParkingDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private  String name;

    private String mobileNumber;

    private String vehicleNumber;

    private  VehicleType vehicleType;

    private String model;

    private int  cost;

    private int totalPay;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime parkDateAndTime;

}
