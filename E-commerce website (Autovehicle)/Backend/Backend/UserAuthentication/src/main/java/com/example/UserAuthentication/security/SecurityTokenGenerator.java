package com.example.UserAuthentication.security;

import com.example.UserAuthentication.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> createToken(User user);
}
