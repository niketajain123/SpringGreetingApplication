package com.example.SpringGreetingApplication.controller;
import com.example.SpringGreetingApplication.model.Greeting;
import com.example.SpringGreetingApplication.service.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

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
    @GetMapping
    public String getPersonalizedGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return "{\"message\": \"" + greetingService.getGreetingMessage(firstName, lastName) + "\"}";
    }
    @PostMapping
    public ResponseEntity<?> greet(@RequestParam(required = false) String firstName,
                                   @RequestParam(required = false) String lastName) {
        try {
            Greeting greeting = greetingService.saveGreeting(firstName, lastName);
            return ResponseEntity.ok(greeting);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Something went wrong! " + e.getMessage()));
        }
    }
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}