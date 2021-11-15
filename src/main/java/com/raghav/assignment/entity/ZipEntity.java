package com.raghav.assignment.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Zipcodes")
@Entity
public class ZipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String countryCode;
    @Column(nullable = false)
    private int zipCode;
    private String  placeName;
    private String stateName;
    @Column(name="STATE_CODE", nullable = false,length = 2)
    @Size(min=2,max=2, message="State Code Should Be of Two Characters.")
    private String stateCode;
    private String county;
    private String province;
    private String community1;
    private String community2;
    double latitude;
    double longitude;
    int accuracy;



}

