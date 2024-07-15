package com.example.tripease.repository;

import com.example.tripease.Enum.Gender;
import com.example.tripease.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface customerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByGender(Gender gender);
    List<Customer> findByGenderAndAge(Gender gender, int age);


// using hql- hibernate
//    @Query("select c from Customer c where c.gender = :gender and c.age > :age")
//    List<Customer> findByGenderAndAgeGreaterThan(@Param("gender") Gender gender,
//                                                 @Param("age") int age);

    // Using sql - Native query
    @Query(value = "select * from customer_info where gender = :gender and age > :age",nativeQuery = true)
    List<Customer> findByGenderAndAgeGreaterThan(@Param("gender") String gender,
                                                 @Param("age") int age);
}
