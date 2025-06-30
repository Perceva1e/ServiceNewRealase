package com.example.newreleaseservice.dto;

import lombok.Data;

@Data
public class PersonnelDTO {
    private Long id;
    private String position;
    private PersonDTO person;
}