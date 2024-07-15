package com.example.tripease.controller;

import com.example.tripease.dto.request.driverRequest;
import com.example.tripease.dto.response.driverResponse;
import com.example.tripease.service.driverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class driverController {

    @Autowired
    driverService DriverService;

    @PostMapping("/add")
    public driverResponse addDriver(@RequestBody driverRequest DriverRequest){
        return DriverService.addDriver(DriverRequest);
    }
}
