package com.example.tripease.service;

import com.example.tripease.Model.Driver;
import com.example.tripease.dto.request.driverRequest;
import com.example.tripease.dto.response.driverResponse;
import com.example.tripease.repository.driverRepository;
import com.example.tripease.transformer.driverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class driverService {

    @Autowired
    driverRepository DriverRepository;
    public driverResponse addDriver(driverRequest DriverRequest) {
        Driver driver = driverTransformer.driverRequestToDriver(DriverRequest);

        Driver savedDriver = DriverRepository.save(driver);

        return driverTransformer.driverToDriverResponse(savedDriver);
    }
}
