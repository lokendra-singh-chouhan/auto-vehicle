package com.example.UserVehicleService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND,reason = "User Details Already Found")
public class UserAlreadyExistException extends Exception{
}
