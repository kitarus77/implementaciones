package com.example.implementations.services;


import com.example.implementations.api.HelloApiDelegate;
import com.example.implementations.model.GetHelloWorld200Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HelloWorldService implements HelloApiDelegate {

    @Override
    public ResponseEntity<GetHelloWorld200Response> getHelloWorld() {
        GetHelloWorld200Response response = new GetHelloWorld200Response();
        response.setMessage("¡Hola, Mundo!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
