package com.example.UserVehicleService.service;

import com.example.UserVehicleService.domain.Vehicle;
import com.example.UserVehicleService.exception.VehicleAlreadyExistException;
import com.example.UserVehicleService.exception.VehicleNotFoundExistException;

import java.util.List;

public interface IVehicleService {


    Vehicle addVehicle(Vehicle vehicle) throws VehicleAlreadyExistException;

    List<Vehicle> getAllVehicles() throws VehicleNotFoundExistException;

    List<Vehicle> deleteVehicle(String vehicleId) throws VehicleNotFoundExistException;

    Vehicle updateVehicle(Vehicle vehicle) throws VehicleNotFoundExistException;


}
