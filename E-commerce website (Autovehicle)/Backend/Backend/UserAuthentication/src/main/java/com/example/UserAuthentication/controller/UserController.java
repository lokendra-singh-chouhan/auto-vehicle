package com.example.UserAuthentication.controller;

import com.example.UserAuthentication.domain.User;
import com.example.UserAuthentication.exception.UserAlreadyExistException;
import com.example.UserAuthentication.exception.UserNotFoundException;
import com.example.UserAuthentication.security.SecurityTokenGeneratorImpl;
import com.example.UserAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;
    private SecurityTokenGeneratorImpl securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGeneratorImpl securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException {
        try {
            Map<String, String> map = null;
            User userObj = userService.findByEmailIdAndPassword(user.getEmailId(), user.getPassword());
            if (userObj.getEmailId().equals(user.getEmailId())) {
                map = securityTokenGenerator.createToken(user);
            }
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("User Detail Is Not Found", HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyExistException {
        try {
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
        } catch (UserAlreadyExistException e) {
            return new ResponseEntity<>("User Detail Is Already Exist", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
