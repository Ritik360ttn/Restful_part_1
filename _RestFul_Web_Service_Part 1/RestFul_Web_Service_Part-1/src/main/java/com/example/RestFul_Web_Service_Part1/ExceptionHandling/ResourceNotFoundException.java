package com.example.RestFul_Web_Service_Part1.ExceptionHandling;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}