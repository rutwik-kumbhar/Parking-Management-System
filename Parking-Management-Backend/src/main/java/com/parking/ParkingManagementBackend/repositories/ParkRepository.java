package com.parking.ParkingManagementBackend.repositories;


import com.parking.ParkingManagementBackend.entities.Floor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParkRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Floor getParkingSlot(String column, String columnCount) {
        try{
            String jpql = "SELECT f FROM Floor f WHERE f.parkCount < f.totalCapacity AND f.twoWheelerCount < f.towWheelerCapacity";
//            String jpql = "SELECT f. FROM Floor f WHERE f.parkCount < f.totalCapacity AND f." + columnCount + " < f." + column;
            Query query = entityManager.createQuery(jpql);
            query.setMaxResults(1); // Set max results to 1
            List<Floor> resultList = query.getResultList();
            return resultList.isEmpty() ? null : resultList.get(0);
        }catch (Exception ex){
            ex.printStackTrace(); // Print the stack trace for debugging
            return null;
        }

    }



}
