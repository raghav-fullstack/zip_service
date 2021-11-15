package com.raghav.assignment.auth;

import lombok.*;

import java.util.Date;

@Data
@Value
@Builder
class TokenResponse {

    String token;
    String userName;
    Date tokenExpirationTimeStamp ;

   public TokenResponse() {
        userName = "";
        token = "";
        tokenExpirationTimeStamp = null;
    }

    public TokenResponse(String token, String userName, Date tokenExpirationTimeStamp) {
        this.token = token;
        this.userName = userName;
        this.tokenExpirationTimeStamp = tokenExpirationTimeStamp;
    }


}
