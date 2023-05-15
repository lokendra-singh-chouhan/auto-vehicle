package com.example.UserAuthentication.service;

import com.example.UserAuthentication.domain.User;
import com.example.UserAuthentication.exception.UserAlreadyExistException;
import com.example.UserAuthentication.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {
    public User saveUser(User user)throws UserAlreadyExistException;
    public User findByEmailIdAndPassword(String emailId, String password) throws UserNotFoundException;
}

