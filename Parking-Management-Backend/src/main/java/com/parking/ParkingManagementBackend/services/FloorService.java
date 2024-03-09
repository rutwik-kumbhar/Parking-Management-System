package com.parking.ParkingManagementBackend.services;

import com.parking.ParkingManagementBackend.entities.Floor;
import com.parking.ParkingManagementBackend.exceptions.ResourcesNotFoundException;

import java.util.List;

public interface FloorService {


    /**
     * This method add new floor
     * @param floor
     * @return newly added floor
     */
    Floor addFloor(Floor floor) ;

    /**
     * This method get floor by id
     * @param floorId
     * @return floor
     */
    Floor getFloorById(int floorId) throws ResourcesNotFoundException;


    /**
     * This method get all floors
     * @return list of floors
     */
    List<Floor> getAllFloor();

    /**
     * This method get floor by floor number
     * @param floor
     * @return floor
     */
    Floor getFloorByFloor(int floor);



    /**
     * This method for update existing floor details
     * @param floorId
     * @param floor
     * @return updated floor
     */
    Floor updateFloor(int floorId , Floor floor) throws ResourcesNotFoundException;

    /**
     * This method delete floor
     * @param floorId
     * @return deleted floor
     */
    Floor deleteFloor(int floorId) throws  ResourcesNotFoundException;

}
