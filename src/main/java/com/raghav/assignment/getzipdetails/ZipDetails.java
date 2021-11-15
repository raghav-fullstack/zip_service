package com.raghav.assignment.getzipdetails;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZipDetails {

    String placeName;
    String county;
    String stateName;
    String stateCode;

}
