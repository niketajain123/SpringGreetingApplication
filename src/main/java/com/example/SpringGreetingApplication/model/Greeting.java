package com.example.SpringGreetingApplication.model;
import jakarta.persistence.*;

@Entity
@Table(name = "GREETINGS")
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "greeting_seq")
    @SequenceGenerator(name = "greeting_seq", sequenceName = "GREETING_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false) // Ensure MESSAGE cannot be NULL
    private String message;

    public Greeting() {}

    public Greeting(String message) {
        if (message == null || message.trim().isEmpty()) {
            this.message = "Hello, World!";
        } else {
            this.message = message;
        }
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}