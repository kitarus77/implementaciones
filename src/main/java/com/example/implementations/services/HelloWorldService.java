package com.example.implementations.services;


import com.example.implementations.api.HelloApiDelegate;
import com.example.implementations.model.GetHelloWorld200Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService implements HelloApiDelegate {

    @Override
    public ResponseEntity<GetHelloWorld200Response> getHelloWorld() {
        GetHelloWorld200Response response = new GetHelloWorld200Response();
        response.setMessage("¡Hola, Mundo!");
        return ResponseEntity.ok(response);
    }
}
