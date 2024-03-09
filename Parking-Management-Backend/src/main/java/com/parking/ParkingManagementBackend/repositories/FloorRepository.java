package com.parking.ParkingManagementBackend.repositories;

import com.parking.ParkingManagementBackend.entities.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FloorRepository extends JpaRepository<Floor,Integer> {


    Optional<Floor> findByFloor(int floor);
}
