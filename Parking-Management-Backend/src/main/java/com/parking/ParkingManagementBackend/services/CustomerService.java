package com.parking.ParkingManagementBackend.services;

import com.parking.ParkingManagementBackend.entities.Customer;
import com.parking.ParkingManagementBackend.entities.ParkingDetails;
import org.springframework.web.bind.annotation.RequestBody;

public interface CustomerService {


    /**
     * This method for park vehicle
     * @param customer
     * @return Parking Details
     */
    ParkingDetails parkVehicle(@RequestBody Customer customer);

    ParkingDetails removeVehicle(String vehicleNumber);
}
