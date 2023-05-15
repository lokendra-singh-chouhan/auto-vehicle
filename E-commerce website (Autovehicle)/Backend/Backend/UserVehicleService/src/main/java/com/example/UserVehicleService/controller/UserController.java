package com.example.UserVehicleService.controller;

import com.example.UserVehicleService.domain.User;
import com.example.UserVehicleService.domain.Vehicle;
import com.example.UserVehicleService.exception.UserAlreadyExistException;
import com.example.UserVehicleService.exception.UserNotFoundExistException;
import com.example.UserVehicleService.exception.VehicleAlreadyExistException;
import com.example.UserVehicleService.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class UserController {
    private UserService userService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistException {
        try {
            User addedUser = userService.registerUser(user);
            if (addedUser == null) {
                responseEntity= new ResponseEntity<>("Error Occurred while add new User", HttpStatus.BAD_REQUEST);
            } else {
                responseEntity= new ResponseEntity<>(addedUser, HttpStatus.ACCEPTED);
            }
        } catch (UserAlreadyExistException e) {
            throw new UserAlreadyExistException();
        } catch (Exception e) {
            System.out.println(e);
        }
        return responseEntity;
    }

    @PostMapping("/user/saveCart")
    public ResponseEntity<User> saveVehicleToCart(@RequestBody Vehicle vehicle, HttpServletRequest request) {
        try {
            System.out.println("header " + request.getHeader("Authorization"));
            Claims claims = (Claims) request.getAttribute("claims");
            System.out.println("email from claims = " + claims.getSubject());
            String emailId = claims.getSubject();
            System.out.println("email = " + emailId);
            User updatedUser = userService.saveVehicleToCart(emailId, vehicle);
            return ResponseEntity.status(HttpStatus.CREATED).body(updatedUser);
        } catch (UserNotFoundExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/user/getCartItems")
    public ResponseEntity<?> getAllVehicle(HttpServletRequest httpServletRequest) throws UserNotFoundExistException{
        try{
            System.out.println("header" +httpServletRequest.getHeader("Authorization"));
            Claims claims = (Claims) httpServletRequest.getAttribute("claims");
            System.out.println("email from claims = " + claims.getSubject());
            String emailId = claims.getSubject();
            System.out.println("email = "+emailId);
            responseEntity = new ResponseEntity<>(userService.getAllVehicle(emailId), HttpStatus.OK);
        }catch(UserNotFoundExistException e)
        {
            throw new UserNotFoundExistException();
        }
        return responseEntity;
    }

    @DeleteMapping("/user/cart/{vehicleId}")
    public ResponseEntity<?> deleteVehicleFromCart(@PathVariable String vehicleId, HttpServletRequest httpServletRequest) throws UserNotFoundExistException{
        Claims claims = (Claims) httpServletRequest.getAttribute("claims");
        System.out.println("email from claims = " + claims.getSubject());
        String emailId = claims.getSubject();
        System.out.println("email = "+emailId);
        try {
            responseEntity = new ResponseEntity<>(userService.deleteVehicleFromCart(emailId,vehicleId), HttpStatus.OK);
        } catch (UserNotFoundExistException e) {
            throw new UserNotFoundExistException();
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
   }

}
