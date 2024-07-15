package com.example.tripease.transformer;

import com.example.tripease.Enum.TripStatus;
import com.example.tripease.Model.Booking;
import com.example.tripease.Model.Cab;
import com.example.tripease.Model.Customer;
import com.example.tripease.Model.Driver;
import com.example.tripease.dto.request.bookingRequest;
import com.example.tripease.dto.response.bookingResponse;

public class bookingTransformer {

    public static Booking bookingRequestToBooking(bookingRequest BookingRequest, double perKmRate){
        return Booking.builder()
                .pickup(BookingRequest.getPickup())
                .destination(BookingRequest.getDestination())
                .tripDistanceInKm(BookingRequest.getTripDistanceInKm())
                .tripStatus(TripStatus.InProgress)
                .billAmount(BookingRequest.getTripDistanceInKm()*perKmRate)
                .build();
    }

    public static bookingResponse bookingToBookingResponse(Booking booking,
                                                           Customer customer,
                                                           Cab cab,
                                                           Driver driver){
        return bookingResponse.builder()
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .tripDistanceInKm(booking.getTripDistanceInKm())
                .tripStatus(booking.getTripStatus())
                .billAmount(booking.getBillAmount())
                .bookedAt(booking.getBookedAt())
                .lastUpdatedAt(booking.getLastUpdatedAt())
                .Customer(customerTransformer.customerToCustomerResponse(customer))
                .Cab(cabTransformer.cabToCabResponse(cab,driver))
                .build();
    }
}
