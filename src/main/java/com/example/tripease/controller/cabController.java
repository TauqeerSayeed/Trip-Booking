package com.example.tripease.controller;

import com.example.tripease.dto.request.cabRequest;
import com.example.tripease.dto.response.cabResponse;
import com.example.tripease.service.cabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class cabController {

    @Autowired
    cabService CabService;

    @PostMapping("/register/driver/{id}")
    public cabResponse registerCab(@RequestBody cabRequest CabRequest ,
                                   @PathVariable("id") int driverId){
        return CabService.registerCab(CabRequest, driverId);
    }
}
