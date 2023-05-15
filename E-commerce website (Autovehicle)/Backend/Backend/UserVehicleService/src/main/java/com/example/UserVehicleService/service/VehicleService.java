package com.example.UserVehicleService.service;

import com.example.UserVehicleService.domain.Vehicle;
import com.example.UserVehicleService.exception.VehicleAlreadyExistException;
import com.example.UserVehicleService.exception.VehicleNotFoundExistException;
import com.example.UserVehicleService.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {
    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

//    @Override
//    public Vehicle addVehicle(Vehicle vehicle) throws VehicleAlreadyExistException {
//        if (vehicleRepository.findById(vehicle.getVehicleId()).isPresent()) {
//            throw new VehicleAlreadyExistException();
//        } else {
//            return vehicleRepository.save(vehicle);
//        }
//    }
//String vid = "101";
//    @Override
//    public Vehicle addVehicle(Vehicle vehicle) throws VehicleAlreadyExistException {
//        // Generate a new ID starting at "101"
//
//        List<Vehicle> vehicles = vehicleRepository.findAll();
//        if (!vehicles.isEmpty()) {
//            // Get the current highest ID and increment it
//            int currentMaxId = Integer.parseInt(vehicles.get(vehicles.size() - 1).getVehicleId());
//            vid = Integer.toString(currentMaxId + 1);
//        }
//        vehicle.setVehicleId(vid);
//
//        // Check if the vehicle already exists in the database
//        if (vehicleRepository.findById(vehicle.getVehicleId()).isPresent()) {
//            throw new VehicleAlreadyExistException();
//        } else {
//            return vehicleRepository.save(vehicle);
//        }
//    }

    // Other methods

    String vid = "1001";
    @Override
    public Vehicle addVehicle(Vehicle vehicle) throws VehicleAlreadyExistException {
        // Generate a new ID starting at "1001"
        vehicle.setVehicleId(vid);
        // Check if the vehicle already exists in the database
        if (vehicleRepository.findById(vehicle.getVehicleId()).isPresent()) {
            throw new VehicleAlreadyExistException();
        } else {
            // Increment the ID for the next vehicle
            int currentId = Integer.parseInt(vid);
            vid = Integer.toString(currentId + 1);

            return vehicleRepository.save(vehicle);
        }
    }


































    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> deleteVehicle(String vehicleId) throws VehicleNotFoundExistException {
        if(vehicleRepository.findById(vehicleId).isEmpty()){
            throw new VehicleNotFoundExistException();
        }
        vehicleRepository.deleteById(vehicleId);
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) throws VehicleNotFoundExistException{
        Vehicle existingvehicle = vehicleRepository.findById(vehicle.getVehicleId()).get();
        if (existingvehicle == null) {
            throw new VehicleNotFoundExistException();
        }
        if (vehicle.getVehicleName() != null) {
            existingvehicle.setVehicleName(vehicle.getVehicleName());
        }
        if (vehicle.getVehicleCategory() != null) {
            existingvehicle.setVehicleCategory(vehicle.getVehicleCategory());
        }
        return vehicleRepository.save(existingvehicle);
    }
}
