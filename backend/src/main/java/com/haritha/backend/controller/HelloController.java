package com.haritha.backend.controller;

import com.haritha.backend.dto.HelloResponse;
import com.haritha.backend.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class HelloController {
    private final GreetingService greetingService;

    @GetMapping("/hello")
    public ResponseEntity<HelloResponse> sayHello(){
        String message = greetingService.getGreeting();
        return ResponseEntity.ok(new HelloResponse(message));
    }
    // test comment
    // test comment 2
}
