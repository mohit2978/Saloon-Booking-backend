package com.app.paymentservice.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public ResponseEntity<String> HomeControllerHandler() {
        
        return ResponseEntity.status(HttpStatus.OK)
                .body("welcome to salon booking system, user api");
    }
}
