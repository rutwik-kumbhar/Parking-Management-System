package com.parking.ParkingManagementBackend.services.impl;

import com.parking.ParkingManagementBackend.entities.Floor;
import com.parking.ParkingManagementBackend.entities.Slot;
import com.parking.ParkingManagementBackend.exceptions.ResourcesNotFoundException;
import com.parking.ParkingManagementBackend.repositories.FloorRepository;
import com.parking.ParkingManagementBackend.services.FloorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FloorServiceImpl implements FloorService {

    private final FloorRepository floorRepository;

    @Override
    public Floor addFloor(Floor floor) {

        int capacity  = floor.getTowWheelerCapacity() + floor.getFourWheelerCapacity() + floor.getOtherCapacity();
        floor.setTotalCapacity(capacity);


        for(int i=1;i<=capacity;i++){
          Slot slot =  new Slot();
          slot.setSlotNumber(i);
          slot.setFloor(floor);
         floor.getSlots().add(slot);
        }
        return floorRepository.save(floor);
    }

    @Override
    public Floor getFloorById(int floorId) throws ResourcesNotFoundException {
        return floorRepository.findById(floorId).orElseThrow(()-> new ResourcesNotFoundException("floor not found given id"));
    }

    @Override
    public List<Floor> getAllFloor() {
        return floorRepository.findAll();
    }

    @Override
    public Floor getFloorByFloor(int floor) {
        return floorRepository.findByFloor(floor).orElseThrow(()-> new ResourcesNotFoundException("Floor not found by give floor number" + floor));
    }



    @Override
    public Floor updateFloor(int floorId, Floor floor) throws ResourcesNotFoundException {
        Floor existFloor  =  this.getFloorById(floorId);

        existFloor.setTowWheelerCapacity(floor.getTowWheelerCapacity());
        existFloor.setFourWheelerCapacity(floor.getFourWheelerCapacity());
        existFloor.setOtherCapacity(floor.getOtherCapacity());
        return floorRepository.save(existFloor);
    }

    @Override
    public Floor deleteFloor(int floorId) throws ResourcesNotFoundException {
        Floor floor =  this.getFloorById(floorId);
        floorRepository.delete(floor);
        return floor;
    }
}
