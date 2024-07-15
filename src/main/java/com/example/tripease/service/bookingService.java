package com.example.tripease.service;

import com.example.tripease.Model.Booking;
import com.example.tripease.Model.Cab;
import com.example.tripease.Model.Customer;
import com.example.tripease.Model.Driver;
import com.example.tripease.dto.request.bookingRequest;
import com.example.tripease.dto.response.bookingResponse;
import com.example.tripease.exception.CabUnavailableException;
import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.repository.bookingRepository;
import com.example.tripease.repository.cabRepository;
import com.example.tripease.repository.customerRepository;
import com.example.tripease.repository.driverRepository;
import com.example.tripease.transformer.bookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class bookingService {

    @Autowired
    customerRepository CustomerRepository;

    @Autowired
    cabRepository CabRepository;

    @Autowired
    driverRepository DriverRepository;

    @Autowired
    bookingRepository BookingRepository;
    public bookingResponse bookCab(bookingRequest bookingRequest, int customerId) {
        Optional<Customer> optionalCustomer = CustomerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer id");
        }
        Customer customer  = optionalCustomer.get();
        Cab availableCab = CabRepository.getAvailableCabRandomly();
        if(availableCab==null){
            throw new CabUnavailableException("Cab is not available right now!");
        }
        Booking booking  = bookingTransformer.bookingRequestToBooking(bookingRequest, availableCab.getPerKmRate());
        Booking savedBooking = BookingRepository.save(booking);
        availableCab.setAvailable(false);

        customer.getBookings().add(savedBooking);
        Driver driver = DriverRepository.getDriverByCabId(availableCab.getCabId());
        driver.getBookings().add(savedBooking);

        Customer savedCustomer = CustomerRepository.save(customer);
        Driver savedDriver = DriverRepository.save(driver);

        return bookingTransformer.bookingToBookingResponse(savedBooking,savedCustomer,availableCab,savedDriver);


    }
}
