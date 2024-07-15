package com.example.tripease.dto.response;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class cabResponse {
    int cabId;

    String cabNumber;

    String cabModel;

    double perKmRate;

    boolean available;

    private driverResponse driver;

}
