package com.raghav.assignment.getZipCountyDetails;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZipCountyDetails {

    String stateName;
    String stateCode;
    long numberOfCounties;
    long numberOfZipCodes;

}
