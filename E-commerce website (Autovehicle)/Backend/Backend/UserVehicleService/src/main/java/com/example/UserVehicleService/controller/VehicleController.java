package com.example.UserVehicleService.controller;

import com.example.UserVehicleService.domain.Vehicle;
import com.example.UserVehicleService.exception.VehicleAlreadyExistException;
import com.example.UserVehicleService.exception.VehicleNotFoundExistException;
import com.example.UserVehicleService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/addVehicle")
    public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle) throws VehicleAlreadyExistException {
        Vehicle addedVehicle = vehicleService.addVehicle(vehicle);
        if (addedVehicle == null) {
            return new ResponseEntity<>("Error Occurred while add new Furniture", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(addedVehicle, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/getAllVehicles")
    public ResponseEntity<?> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteVehicle/{vehicleId}")
    public ResponseEntity<?> deleteVehicle(@PathVariable String vehicleId) throws VehicleNotFoundExistException {
        return new ResponseEntity<>(vehicleService.deleteVehicle(vehicleId), HttpStatus.OK);
    }

    @PutMapping("/updateVehicle")
    public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle) throws VehicleNotFoundExistException {
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicle), HttpStatus.OK);
    }
}
