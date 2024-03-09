package com.parking.ParkingManagementBackend.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "floors")
public class Floor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int floor;

    private int towWheelerCapacity;

    private  int twoWheelerCount = 0;

    private  int fourWheelerCapacity;

    private  int fourWheelerCount = 0;

    private int otherCapacity;

    private  int otherCount = 0;

    private int totalCapacity;

    private int parkCount = 0;

    @OneToMany(mappedBy = "floor" , cascade = CascadeType.ALL)
    private final List<Vehicle> vehicles = new ArrayList<>();


    @OneToMany(mappedBy = "floor" , cascade = CascadeType.ALL )
    private final  List<Slot>  slots = new ArrayList<>();
}
