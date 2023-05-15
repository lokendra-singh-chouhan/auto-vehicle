package com.example.UserVehicleService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND,reason = "Vehicle Detail Already Found")
public class VehicleAlreadyExistException extends Exception{
}
