package com.parking.ParkingManagementBackend.exceptions;

public class ResourcesNotFoundException extends RuntimeException {

    public ResourcesNotFoundException() {
        super();
    }

    public ResourcesNotFoundException(String message) {
        super(message);
    }
}
