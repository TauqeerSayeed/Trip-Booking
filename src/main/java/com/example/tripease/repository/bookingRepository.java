package com.example.tripease.repository;

import com.example.tripease.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookingRepository extends JpaRepository<Booking,Integer> {

}
