package com.example.tripease.service;

import com.example.tripease.Enum.Gender;
import com.example.tripease.Model.Customer;
import com.example.tripease.dto.request.customerRequest;
import com.example.tripease.dto.response.customerResponse;
import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.repository.customerRepository;
import com.example.tripease.transformer.customerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class customerService {

    @Autowired
    customerRepository CustomerRepository;

    public List<customerResponse> getAllByGender(Gender gender) {
        List<Customer> customers = CustomerRepository.findByGender(gender);
        //entity--> Dto
        List<customerResponse> CustomerResponse = new ArrayList<>();
        for(Customer customer : customers ){
            CustomerResponse.add(customerTransformer.customerToCustomerResponse(customer));
        }
        return CustomerResponse;
    }

    public customerResponse addCustomer(customerRequest CustomerRequest) {

        //request DTO to entity conversion
        Customer customer = customerTransformer.customerRequestToCustomer(CustomerRequest);

        //saving in database
        Customer savedCustomer = CustomerRepository.save(customer);

        //entity to DTO conversion
        return customerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public customerResponse getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = CustomerRepository.findById(customerId);

        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }

        //entity to dto
        Customer savedCustomer = optionalCustomer.get();
        return customerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<customerResponse> getAllByGenderAndAge(Gender gender, int age) {
        List<Customer> customers = CustomerRepository.findByGenderAndAge(gender,age);

        List<customerResponse> CustomerResponse = new ArrayList<>();
        for(Customer customer : customers ){
            CustomerResponse.add(customerTransformer.customerToCustomerResponse(customer));
        }
        return CustomerResponse;
    }

    public List<customerResponse> getAllByGenderAndGreaterThanAge(String gender, int age) {
        List<Customer> customers = CustomerRepository.findByGenderAndAgeGreaterThan(gender,age);

        List<customerResponse> CustomerResponse = new ArrayList<>();
        for(Customer customer : customers ){
            CustomerResponse.add(customerTransformer.customerToCustomerResponse(customer));
        }
        return CustomerResponse;
    }
}
