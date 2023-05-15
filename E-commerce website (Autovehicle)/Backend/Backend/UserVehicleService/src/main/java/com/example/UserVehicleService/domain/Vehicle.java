package com.example.UserVehicleService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vehicle {

    @Id
    private String vehicleId;
    private String vehicleName;
    private String vehicleCategory;

    public Vehicle(String vehicleId, String vehicleName, String vehicleCategory) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.vehicleCategory = vehicleCategory;
    }

    public Vehicle() {
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehicleCategory='" + vehicleCategory + '\'' +
                '}';
    }
}
