package com.example.tripease.transformer;

import com.example.tripease.Model.Driver;
import com.example.tripease.dto.request.driverRequest;
import com.example.tripease.dto.response.driverResponse;

public class driverTransformer {

    public static driverResponse driverToDriverResponse(Driver driver){
        return driverResponse.builder()
                .id(driver.getDriverId())
                .name(driver.getName())
                .age(driver.getAge())
                .emailId(driver.getEmailId())
                .build();
    }

    public static Driver driverRequestToDriver(driverRequest Driverrequest){
        return Driver.builder()
                .name(Driverrequest.getName())
                .age(Driverrequest.getAge())
                .emailId(Driverrequest.getEmailId())
                .build();
    }
}
