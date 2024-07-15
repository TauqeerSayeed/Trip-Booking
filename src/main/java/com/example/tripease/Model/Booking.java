package com.example.tripease.Model;

import com.example.tripease.Enum.TripStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "booking_details")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookingId;

    String pickup;
    String destination;
    double tripDistanceInKm;
    TripStatus tripStatus;
    double billAmount;

    @CreationTimestamp
    Date bookedAt;

    @UpdateTimestamp
    Date lastUpdatedAt;


}
