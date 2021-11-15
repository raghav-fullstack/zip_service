package com.raghav.assignment.auth;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class AuthController {

    @Value("${secure.service.token.age:0}")
    long tokenExpirationTimeInSeconds;

    @Value("${secure.service.user}")
    String authuser;

    @Value("${secure.service.password}")
    String authpassword;

    @PostMapping("/token")
    public TokenResponse getToken(@RequestBody User loginUser) throws RuntimeException {

        //log.info("This is Token controller.");
        String jwtToken = "";

        if (loginUser.getUserId() != null && loginUser.getUserId().equals(authuser) && loginUser.getPassword() != null
                && loginUser.getPassword().equals(authpassword)) {

            long expiration = tokenExpirationTimeInSeconds * 1000;
            Date ExpirationDate = new Date(System.currentTimeMillis() + expiration);
            jwtToken = Jwts.builder().setSubject(loginUser.getUserId()).claim("roles", "user").setIssuedAt(new Date())
                    .setExpiration(ExpirationDate).signWith(SignatureAlgorithm.HS256, "secretkey").compact();


            TokenResponse tokenResponse = new TokenResponse().builder().userName(loginUser.getUserId()).token(jwtToken).tokenExpirationTimeStamp(ExpirationDate).build();

            return tokenResponse;

        } else {
            throw new RuntimeException("Invalid User/Password :" + loginUser.getUserId());
        }

    }


}
