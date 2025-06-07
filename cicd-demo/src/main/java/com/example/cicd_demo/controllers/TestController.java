package com.example.cicd_demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> getTestData() {
        return ResponseEntity.ok("Hello world");
    }
}
