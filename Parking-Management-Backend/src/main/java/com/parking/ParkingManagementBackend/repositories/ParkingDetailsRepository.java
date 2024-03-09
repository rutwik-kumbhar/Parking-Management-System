package com.parking.ParkingManagementBackend.repositories;

import com.parking.ParkingManagementBackend.entities.ParkingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingDetailsRepository extends JpaRepository<ParkingDetails,Integer> {

    Optional<ParkingDetails> findByVehicleNumber(String vehicleNo);
}
