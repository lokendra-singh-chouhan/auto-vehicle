package com.example.UserVehicleService.service;

import com.example.UserVehicleService.domain.User;
import com.example.UserVehicleService.domain.Vehicle;
import com.example.UserVehicleService.exception.UserAlreadyExistException;
import com.example.UserVehicleService.exception.UserNotFoundExistException;
import com.example.UserVehicleService.exception.VehicleNotFoundExistException;
import com.example.UserVehicleService.proxy.UserProxy;
import com.example.UserVehicleService.repository.UserRepository;
import com.example.UserVehicleService.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;//This line declares a private instance variable of type UserRepository named userRepository.
    // This variable will be used to access the database to perform CRUD (Create, Read, Update, Delete)
    // operations on theUserentity.
    private UserProxy userProxy;

    @Autowired
    public UserService(UserRepository userRepository, UserProxy userProxy) {
        this.userRepository = userRepository;
        this.userProxy = userProxy;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistException {
        if (userRepository.findById(user.getEmailId()).isPresent()) {
            throw new UserAlreadyExistException();
        }
        User saveUser = userRepository.save(user);
        if (!saveUser.getEmailId().isEmpty()) {
            ResponseEntity r = userProxy.addUser(user);
            System.out.println(r.getBody());
        }
        return saveUser;
    }

    @Override
    public User saveVehicleToCart(String emailId, Vehicle vehicle) throws UserNotFoundExistException {
        Optional<User> optionalUser = userRepository.findById(emailId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundExistException();
        }
        User user = optionalUser.get();
        System.out.println("first" + " " + user);
        if (user.getCart() == null) {
            user.setCart(new ArrayList<>(Arrays.asList(vehicle)));
            System.out.println("second" + " " + user);
        } else {
            user.getCart().add(vehicle);
            System.out.println("third" + " " + user);
        }
        return userRepository.save(user);
    }

    @Override
    public List<Vehicle> getAllVehicle(String emailId) throws UserNotFoundExistException {
        List<Vehicle> cart = userRepository.findById(emailId).get().getCart();
        if (cart == null) {
            throw new UserNotFoundExistException();
        }
        return cart;
    }

    @Override
    public List<Vehicle> deleteVehicleFromCart(String emailId, String vehicleId) throws UserNotFoundExistException {
        User user = userRepository.findById(emailId).orElseThrow(UserNotFoundExistException::new);
        List<Vehicle> cart = user.getCart();
        cart.removeIf(vehicle -> vehicle.getVehicleId().equals(vehicleId));
        userRepository.save(user);
        return cart;
    }

}
