package com.parking.ParkingManagementBackend.controllers;


import com.parking.ParkingManagementBackend.entities.Customer;
import com.parking.ParkingManagementBackend.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vehicle")
public class AdminController {


    private final CustomerService customerService;


    @PostMapping("/park")
    public ResponseEntity<?> parkVehicle(@RequestBody Customer customer){
        return  new ResponseEntity<>(customerService.parkVehicle(customer), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeVehicle(@PathVariable("id") String vehicleId){
        return  new ResponseEntity<>(customerService.removeVehicle(vehicleId), HttpStatus.CREATED);
    }


}
