package com.example.implementations.services;

import com.example.implementations.aoplogs.annotations.AutoLog;
import com.example.implementations.api.HelloApiDelegate;
import com.example.implementations.model.GetHelloWorld200Response;
import com.example.implementations.trace.annotations.AutoTrace;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HelloWorldService implements HelloApiDelegate {

    @AutoLog
    @AutoTrace
    @Override
    public ResponseEntity<GetHelloWorld200Response> getHelloWorld() {
        GetHelloWorld200Response response = new GetHelloWorld200Response();
        System.out.println("Ejecutando lógica de negocio de Hello World");

        //  Simulación random del tiempo de procesado entre 1 y 5 segundos
        try {
            Random random = new Random();
            int delay = 1000 + random.nextInt(4000);
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        response.setMessage("¡Hola, Mundo!");
        return ResponseEntity.ok(response);
    }
}
