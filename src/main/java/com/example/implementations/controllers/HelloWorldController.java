package com.example.implementations.controllers;


import com.example.implementations.api.HelloApiDelegate;
import com.example.implementations.model.GetHelloWorld200Response;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@RequestMapping("/hello")
@Service
public class HelloWorldController implements HelloApiDelegate {

    @Override
//    @GetMapping("/hello")
    public ResponseEntity<GetHelloWorld200Response> getHelloWorld() {
        return HelloApiDelegate.super.getHelloWorld();
    }

//    @GetMapping("/hi")
    public ResponseEntity<?> getHi() {
        return ResponseEntity.ok("hi!!");
    }
}
