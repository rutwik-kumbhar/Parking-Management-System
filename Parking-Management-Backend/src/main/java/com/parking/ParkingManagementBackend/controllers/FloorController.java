package com.parking.ParkingManagementBackend.controllers;


import com.parking.ParkingManagementBackend.entities.Floor;
import com.parking.ParkingManagementBackend.services.FloorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/floor")
public class FloorController {

    private final FloorService floorService;


    @PostMapping()
    public ResponseEntity<?> addFloor(@RequestBody Floor floor){
           return new ResponseEntity<Floor>(floorService.addFloor(floor), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Floor> getFloor(@PathVariable int  id){
        return new ResponseEntity<Floor>(floorService.getFloorById(id), HttpStatus.OK);
    }



    @PutMapping("/{id}/update")
    public ResponseEntity<Floor> updateFloor(@PathVariable int id , @RequestBody Floor floor){
        return new ResponseEntity<Floor>(floorService.updateFloor(id,floor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Floor> deleteFloor(@PathVariable int id){
        return new ResponseEntity<Floor>(floorService.deleteFloor(id), HttpStatus.OK);
    }



    @GetMapping("/all")
    public ResponseEntity<List<Floor>> getAllFloor(){
        return new ResponseEntity<List<Floor>>(floorService.getAllFloor(), HttpStatus.OK);
    }



}
