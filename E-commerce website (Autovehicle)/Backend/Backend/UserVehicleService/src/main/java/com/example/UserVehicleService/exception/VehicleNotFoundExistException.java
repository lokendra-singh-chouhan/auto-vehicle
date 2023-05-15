package com.example.UserVehicleService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Vehicle Details Not Found")
public class VehicleNotFoundExistException extends Exception{
}
