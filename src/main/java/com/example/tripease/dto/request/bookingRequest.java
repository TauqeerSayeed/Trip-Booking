package com.example.tripease.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class bookingRequest {
    private String pickup;

    private double tripDistanceInKm;

    private String destination;
}
