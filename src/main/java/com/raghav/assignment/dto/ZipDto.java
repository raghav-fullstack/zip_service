package com.raghav.assignment.dto;


import lombok.*;

@Data
@Builder
public class ZipDto {

     String countryCode;
     String zipCode;
     String  placeName;
     String stateName;
     String stateCode;
     String county;
     String province;
     String community1;
     String community2;
     double latitude;
     double longitude;
     int accuracy;

    public ZipDto(String countryCode, String zipCode, String placeName, String stateName, String stateCode, String county, String province, String community1, String community2, double latitude, double longitude, int accuracy) {
        this.countryCode = countryCode;
        this.zipCode = zipCode;
        this.placeName = placeName;
        this.stateName = stateName;
        this.stateCode = stateCode;
        this.county = county;
        this.province = province;
        this.community1 = community1;
        this.community2 = community2;
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracy = accuracy;
    }

    public ZipDto() {

    }
}
