package com.example.RestFul_Web_Service_Part1.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;

    @NotNull(message = "its should not ne null")
   @jakarta.validation.constraints.Size(min = 5, message = "Name must be of 5 character" )
   @NotBlank(message = "its  not be blank")
    private String name;

    @jakarta.validation.constraints.NotNull(message = "Employee age is required")
    @jakarta.validation.constraints.PositiveOrZero(message = "Employee age should be positive")
    private int age;
}