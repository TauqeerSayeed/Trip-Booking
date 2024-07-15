package com.example.tripease.Model;

import jakarta.persistence.*;
import lombok.*;

import javax.naming.Name;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "cab_info")
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cabId;

    String cabNumber;

    String cabModel;

    double perKmRate;

    boolean available;


}
