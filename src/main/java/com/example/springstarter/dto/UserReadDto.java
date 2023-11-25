package com.example.springstarter.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserReadDto {
    public Long id;
    public String username;
    public LocalDate birthDate;
    public String firstname;
    public String lastname;
}
