package com.example.tripease.Model;

import com.example.tripease.Enum.Gender;
import com.example.tripease.Model.Booking;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "customer_info")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private int age;

    @Column(unique = true,nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    List<Booking> bookings = new ArrayList<>();
}
