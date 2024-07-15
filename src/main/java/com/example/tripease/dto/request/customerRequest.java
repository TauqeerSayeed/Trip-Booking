package com.example.tripease.dto.request;

import com.example.tripease.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class customerRequest {
    private String name;
    private int age;
    private String email;
    private Gender gender;
}
