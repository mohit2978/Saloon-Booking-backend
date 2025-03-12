package com.app.saloonmicroservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/test")
    public String methodTest(){
        return "In Saloon Microservice";
    }

}
