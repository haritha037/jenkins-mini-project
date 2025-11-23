package com.haritha.backend.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreeting() {
        return "Hello from backend!";
    }
}
