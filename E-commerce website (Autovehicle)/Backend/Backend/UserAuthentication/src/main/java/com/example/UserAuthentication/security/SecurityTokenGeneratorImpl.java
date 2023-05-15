package com.example.UserAuthentication.security;

import com.example.UserAuthentication.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{

    @Override
    public Map<String,String> createToken(User user){
        Map<String ,String> tokenMap = new HashMap<>();

        Map<String ,Object> userData = new HashMap<>();
        userData.put("emailId",user.getEmailId());

        String jwtTokenString = Jwts.builder().setClaims(userData)
                .setSubject(user.getEmailId())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret")
                .compact();

        tokenMap.put("token",jwtTokenString);
        tokenMap.put("message","Login Successful");
        tokenMap.put("emailId", user.getEmailId());
        return tokenMap;
    }
}