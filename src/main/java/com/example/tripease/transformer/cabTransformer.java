package com.example.tripease.transformer;

import com.example.tripease.Model.Cab;
import com.example.tripease.Model.Driver;
import com.example.tripease.dto.request.cabRequest;
import com.example.tripease.dto.response.cabResponse;

public class cabTransformer {

    public static Cab cabRequestToCab(cabRequest CabRequest){
        return Cab.builder()
                .cabNumber(CabRequest.getCabNumber())
                .cabModel(CabRequest.getCabModel())
                .perKmRate(CabRequest.getPerKmRate())
                .available(true)
                .build();
    }

    public static cabResponse cabToCabResponse(Cab cab, Driver driver){
        return cabResponse.builder()
                .cabId(cab.getCabId())
                .cabModel(cab.getCabModel())
                .cabNumber(cab.getCabNumber())
                .perKmRate(cab.getPerKmRate())
                .available(cab.isAvailable())
                .driver(driverTransformer.driverToDriverResponse(driver))
                .build();
    }
}
