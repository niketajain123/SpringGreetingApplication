package com.example.SpringGreetingApplication.service;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreetingMessage() {
        return "Hello!! Have a nice day";  // Business logic
    }
}