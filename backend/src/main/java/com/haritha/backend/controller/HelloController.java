package com.haritha.backend.controller;

import com.haritha.backend.dto.HelloResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<HelloResponse> sayHello(){
        return ResponseEntity.ok(new HelloResponse("Hello from backend!"));
    }
}
