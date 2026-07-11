package com.example.rest_service;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public com.example.rest_service.Greeting greeting(@RequestParam(defaultValue = "World") String name) {
        return new com.example.rest_service.Greeting(counter.incrementAndGet(),template.formatted(name));
    }

}