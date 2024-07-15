package com.example.tripease.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class customerResponse {
    private String name;
    private int age;
    private String email;
}
