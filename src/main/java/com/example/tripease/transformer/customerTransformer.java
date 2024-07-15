package com.example.tripease.transformer;

import com.example.tripease.Model.Customer;
import com.example.tripease.dto.request.customerRequest;
import com.example.tripease.dto.response.customerResponse;

public class customerTransformer {
    public static Customer customerRequestToCustomer(customerRequest CustomerRequest){
//        Customer customer = new Customer();
//        customer.setName(CustomerRequest.getName());
//        customer.setAge(CustomerRequest.getAge());
//        customer.setEmail(CustomerRequest.getEmail());
//        customer.setGender(CustomerRequest.getGender());
        //builder
        return Customer.builder()
                .name(CustomerRequest.getName())
                .age(CustomerRequest.getAge())
                .email(CustomerRequest.getEmail())
                .gender(CustomerRequest.getGender())
                .build();
    }

    public static customerResponse customerToCustomerResponse(Customer savedCustomer){
//        customerResponse CustomerResponse = new customerResponse();
//        CustomerResponse.setName(savedCustomer.getName());
//        CustomerResponse.setEmail(savedCustomer.getEmail());
//        CustomerResponse.setAge(savedCustomer.getAge());
        //builder
        return customerResponse.builder()
                .name(savedCustomer.getName())
                .email(savedCustomer.getEmail())
                .age(savedCustomer.getAge())
                .build();
    }

}
