package com.ecommerce.apis.ecommerce.Controllers.helloController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @GetMapping("/")
    public String helloUser()
    {
        return "Hello, new user!";
    }
}
