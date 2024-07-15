package com.example.tripease.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class driverResponse {

    int id;
    private String name;

    private int age;

    private String emailId;
}
