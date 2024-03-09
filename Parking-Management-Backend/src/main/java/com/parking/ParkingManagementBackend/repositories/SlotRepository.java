package com.parking.ParkingManagementBackend.repositories;

import com.parking.ParkingManagementBackend.entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Integer> {
}
