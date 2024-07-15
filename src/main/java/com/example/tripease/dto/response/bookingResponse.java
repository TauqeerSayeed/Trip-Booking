package com.example.tripease.dto.response;

import com.example.tripease.Enum.TripStatus;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class bookingResponse {

    String pickup;

    String destination;

    double tripDistanceInKm;

    TripStatus tripStatus;

    double billAmount;

    Date bookedAt;

    Date lastUpdatedAt;

    customerResponse Customer;
    cabResponse Cab;
}
