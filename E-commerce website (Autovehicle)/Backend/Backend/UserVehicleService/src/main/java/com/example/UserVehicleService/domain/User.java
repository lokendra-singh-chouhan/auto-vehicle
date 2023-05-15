package com.example.UserVehicleService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {

    @Id
    private String emailId;
    private String userName;
    private String password;
    private List<Vehicle> cart;

    public User(String emailId, String userName, String password, List<Vehicle> cart) {
        this.emailId = emailId;
        this.userName = userName;
        this.password = password;
        this.cart = cart;
    }

    public User() {
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Vehicle> getCart() {
        return cart;
    }

    public void setCart(List<Vehicle> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User{" +
                "emailId='" + emailId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", cart=" + cart +
                '}';
    }
}
