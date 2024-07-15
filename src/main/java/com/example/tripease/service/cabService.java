package com.example.tripease.service;


import com.example.tripease.Model.Cab;
import com.example.tripease.Model.Driver;
import com.example.tripease.dto.request.cabRequest;
import com.example.tripease.dto.response.cabResponse;
import com.example.tripease.exception.DriverNotFoundException;
import com.example.tripease.repository.driverRepository;
import com.example.tripease.transformer.cabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class cabService {

    @Autowired
    driverRepository DriverRepository;
    public cabResponse registerCab(cabRequest CabRequest, int driverId) {
        Optional<Driver> optionalDriver = DriverRepository.findById(driverId);

        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundException("driver id invalid");
        }

        Driver driver = optionalDriver.get();
        Cab cab = cabTransformer.cabRequestToCab(CabRequest);
        driver.setCab(cab);

        Driver savedDriver = DriverRepository.save(driver);  //it save both driver and cab

        return cabTransformer.cabToCabResponse(savedDriver.getCab(), savedDriver);

    }
}
