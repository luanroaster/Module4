package com.sqc.academy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("Hello") // API, endpoint
    public String greeting(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "")String address){// http:localhost/8080/Hello?name=Luan&address = Da Nang

        return String.format("Hello %s - %s ", name , address);
    }
}
    