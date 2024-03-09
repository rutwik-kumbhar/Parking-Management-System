package com.parking.ParkingManagementBackend.repositories;

import com.parking.ParkingManagementBackend.entities.Customer;
import com.parking.ParkingManagementBackend.entities.Slot;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {


    @PersistenceContext
    EntityManager entityManager = null;

    Optional<Customer> findByMobileNumber(String mobileNumber);




}

