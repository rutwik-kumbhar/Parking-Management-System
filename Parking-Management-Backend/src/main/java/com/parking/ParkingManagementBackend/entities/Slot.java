package com.parking.ParkingManagementBackend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parking.ParkingManagementBackend.types.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name =  "slots")
public class Slot {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slotId;

    private int slotNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicle;

    private  boolean isPark = true;


    @ManyToOne()
    @JoinColumn(name = "floor_id")
    @JsonIgnore
    private Floor floor;


    @Override
    public String toString() {
        return "Slot{" +
                "slotId=" + slotId +
                ", slotNumber=" + slotNumber +
                ", vehicle=" + vehicle +
                ", isPark=" + isPark +
                '}';
    }
}
