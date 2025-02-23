package com.example.SpringGreetingApplication.service;
import com.example.SpringGreetingApplication.model.Greeting;
import com.example.SpringGreetingApplication.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    @Autowired
    private GreetingRepository greetingRepository;
    public String getGreetingMessage() {
        return "Hello!! Have a nice day";  // Business logic
    }
    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello World!";
        }
    }
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
    public Greeting saveGreeting(String firstName, String lastName) {
        // Default Greeting if no name is provided
        String message = "Hello, World!";

        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, " + lastName + "!";
        }

        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }
}