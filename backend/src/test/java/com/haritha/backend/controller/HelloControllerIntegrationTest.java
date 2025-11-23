package com.haritha.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest  // Loads the FULL application context
@AutoConfigureMockMvc  // Configures MockMvc
class HelloControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    // NO MOCKING - using the real GreetingService

    @Test
    void sayHello_ShouldReturnCorrectMessage() throws Exception {
        mockMvc.perform(get("/api/v1/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello from backend!"));
    }
}
