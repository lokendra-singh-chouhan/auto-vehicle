package com.example.UserVehicleService.proxy;

import com.example.UserVehicleService.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "User-Authentication-service", url ="http://localhost:8085")
public interface UserProxy {

    @PostMapping("/api/v1/register")
    ResponseEntity<?> addUser(@RequestBody User user);
}
