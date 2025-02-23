package com.example.SpringGreetingApplication.controller;
import com.example.SpringGreetingApplication.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final GreetingService greetingService;
    // Constructor-based Dependency Injection
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    @GetMapping
    public String getGreeting() {
        return "Hello!";
    }
    @GetMapping
    public String getGreetingWithMessage() {
        return "{\"message\": \"" + greetingService.getGreetingMessage() + "\"}";
    }
}