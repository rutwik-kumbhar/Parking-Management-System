package com.parking.ParkingManagementBackend.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionFormat {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private  String message;
    private  String uri;
}
