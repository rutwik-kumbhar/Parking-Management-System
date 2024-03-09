package com.parking.ParkingManagementBackend.services.impl;

import com.parking.ParkingManagementBackend.entities.*;
import com.parking.ParkingManagementBackend.exceptions.ResourcesNotFoundException;
import com.parking.ParkingManagementBackend.repositories.*;
import com.parking.ParkingManagementBackend.services.CustomerService;
import com.parking.ParkingManagementBackend.types.VehicleType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ParkingDetailsRepository parkingRepository;
    private final FloorRepository floorRepository;
    private final VehicleRepository vehicleRepository;

    @Override
    public ParkingDetails parkVehicle(Customer customer) {

        List<Floor> floors = floorRepository.findAll();


        Floor f = null;
        boolean isSlotAvailable  = false;

        int cost = 0;
        VehicleType vehicleType = null;

        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());

        Vehicle vehicle = customer.getVehicles().get(0);

        if (vehicle.getType() == VehicleType.valueOf("TWO_WHEELER")) {

            f = floors.stream()
                    .filter(floor -> floor.getParkCount() < floor.getTotalCapacity() &&
                            floor.getFourWheelerCount() < floor.getTowWheelerCapacity())
                    .findFirst().get();

            f.setTwoWheelerCount(f.getTwoWheelerCount() + 1);

            Slot slot = f.getSlots().stream().filter(Slot::isPark).findFirst().get();

            slot.setVehicle(VehicleType.TWO_WHEELER);
            slot.setPark(false);
            slot.setFloor(f);

            cost = 10;
            vehicleType = VehicleType.TWO_WHEELER;

            isSlotAvailable = true;

        } else if (vehicle.getType() == VehicleType.valueOf("FOUR_WHEELER")) {
            f = floors.stream()
                    .filter(floor -> floor.getParkCount() < floor.getTotalCapacity() &&
                            floor.getFourWheelerCount() < floor.getFourWheelerCapacity())
                    .findFirst().get();

            f.setFourWheelerCount(f.getFourWheelerCount());

            Slot slot = f.getSlots().stream().filter(Slot::isPark).findFirst().get();

            slot.setVehicle(VehicleType.FOUR_WHEELER);
            slot.setPark(false);
            slot.setFloor(f);

            cost = 30;
            vehicleType = VehicleType.FOUR_WHEELER;

            isSlotAvailable = true;

        } else {
            f = floors.stream()
                    .filter(floor -> floor.getParkCount() < floor.getTotalCapacity() &&
                            floor.getOtherCount() < floor.getOtherCapacity())
                    .findFirst().get();

            f.setOtherCount(f.getOtherCount());

            Slot slot = f.getSlots().stream().filter(Slot::isPark).findFirst().get();
            slot.setVehicle(VehicleType.OTHER);
            slot.setPark(false);
            slot.setFloor(f);

            cost = 50;
            vehicleType = VehicleType.OTHER;

            isSlotAvailable = true;
        }

        if (f == null && isSlotAvailable == true) {
            throw new ResourcesNotFoundException("Currently Slot is not empty");
        } else {
            vehicle.setFloor(f);
            f.setParkCount(f.getParkCount() + 1);
            f.getVehicles().add(vehicle);
        }


        ParkingDetails parkingDetails = ParkingDetails.builder().name(customer.getFirstName() + " " + customer.getLastName())
                .mobileNumber(customer.getMobileNumber())
                .vehicleNumber(vehicle.getNumber())
                .vehicleType(vehicleType)
                .model(vehicle.getModel())
                .cost(cost)
                .totalPay(0).build();


        if (optionalCustomer.isPresent()) {
            Customer exist = optionalCustomer.get();
            customer.getVehicles().add(vehicle);

            vehicleRepository.save(vehicle);
        } else {
            vehicle.setCustomer(customer);
            customerRepository.save(customer);
        }

        floorRepository.save(f);

        return parkingRepository.save(parkingDetails);
    }

    @Override
    public ParkingDetails removeVehicle(String vehicleNumber) {

        ParkingDetails parkingDetails   =  parkingRepository.findByVehicleNumber(vehicleNumber).orElseThrow(()-> new ResourcesNotFoundException("Vehicle not found give vehicle number" + vehicleNumber));
         int hr =  parkingDetails.getParkDateAndTime().getHour();
        int min = parkingDetails.getParkDateAndTime().getMinute();
        int sec = parkingDetails.getParkDateAndTime().getSecond();

        LocalTime parkedTime  = LocalTime.of(hr, min, sec);

        LocalTime current  = LocalTime.now();

        Duration duration = Duration.between(parkedTime, current);

         int  parkDuration  = (int)duration.toHours();


         if(parkDuration == 0 ){
             parkDuration = 1;
             int pay =  parkingDetails.getCost()*parkDuration;
             parkingDetails.setTotalPay(pay);

         }else{
             int pay =  parkingDetails.getCost()*parkDuration;
             parkingDetails.setTotalPay(pay);
         }



         return parkingRepository.save(parkingDetails);



    }


}
