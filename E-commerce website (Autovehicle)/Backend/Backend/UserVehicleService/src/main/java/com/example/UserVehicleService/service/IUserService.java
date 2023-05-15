package com.example.UserVehicleService.service;

import com.example.UserVehicleService.domain.User;
import com.example.UserVehicleService.domain.Vehicle;
import com.example.UserVehicleService.exception.UserAlreadyExistException;
import com.example.UserVehicleService.exception.UserNotFoundExistException;
import com.example.UserVehicleService.exception.VehicleNotFoundExistException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserService {

     User registerUser(User user) throws UserAlreadyExistException;

     User saveVehicleToCart(String emailId, Vehicle vehicle) throws VehicleNotFoundExistException, UserNotFoundExistException;

     List<Vehicle> getAllVehicle(String emailId) throws UserNotFoundExistException;

     List<Vehicle> deleteVehicleFromCart(String emailId, String vehicleId) throws UserNotFoundExistException;

}
