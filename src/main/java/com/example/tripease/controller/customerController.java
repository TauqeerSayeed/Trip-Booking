package com.example.tripease.controller;

import com.example.tripease.Enum.Gender;
import com.example.tripease.Model.Customer;
import com.example.tripease.dto.request.customerRequest;
import com.example.tripease.dto.response.customerResponse;
import com.example.tripease.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")

public class customerController {

    @Autowired
    customerService CustomerService;

    @PostMapping("/add")
    public customerResponse addCustomer(@RequestBody customerRequest CustomerRequest){
        return CustomerService.addCustomer(CustomerRequest);
    }

    @GetMapping("/get/customer-id/{id}")
    public customerResponse getCustomer(@PathVariable("id") int customerId){
        return CustomerService.getCustomer(customerId);
    }

    @GetMapping("/get/gender/{gender}")
    public List<customerResponse> getAllByGender(@PathVariable("gender") Gender gender){
        return CustomerService.getAllByGender(gender);
    }
    @GetMapping("/get")
    public List<customerResponse> getAllByGenderAndAge(@RequestParam("gender") Gender gender,
                                                       @RequestParam("age") int age){
        return CustomerService.getAllByGenderAndAge(gender,age);
    }

    @GetMapping("/get-greater-age")
    public List<customerResponse> getAllByGenderAndGreaterThanAge(@RequestParam("gender") String gender,
                                                                  @RequestParam  int age){
        return CustomerService.getAllByGenderAndGreaterThanAge(gender,age);
    }
}
