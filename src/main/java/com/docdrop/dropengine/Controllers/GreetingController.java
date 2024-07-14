package com.docdrop.dropengine.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    
    @GetMapping("/greeting")
    public String greeting() {
        return "Hello World";
    }


    @GetMapping("/bye")
    public String bye() {
        return "Bye World";
    }

}
