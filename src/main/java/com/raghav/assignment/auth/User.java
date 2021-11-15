package com.raghav.assignment.auth;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {

    private String userId;
    private String password;

}
