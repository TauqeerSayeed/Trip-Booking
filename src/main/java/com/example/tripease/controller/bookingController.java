package com.example.tripease.controller;

import com.example.tripease.dto.request.bookingRequest;
import com.example.tripease.dto.response.bookingResponse;
import com.example.tripease.service.bookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")

public class bookingController {

    @Autowired
    bookingService BookingService;

    @PostMapping("/book/customer/{customerId}")
    public bookingResponse bookCab(@RequestBody bookingRequest BookingRequest,
                                   @PathVariable("customerId") int customerId){
        return BookingService.bookCab(BookingRequest,customerId);
    }
}
