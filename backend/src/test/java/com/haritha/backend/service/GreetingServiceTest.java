package com.haritha.backend.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingServiceTest {
    @Test
    void testGetGreeting() {
        GreetingService service = new GreetingService();
        assertThat(service.getGreeting()).isEqualTo("Hello from backend!");
    }
}