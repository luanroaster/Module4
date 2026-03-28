package com.sqc.academy.exc1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Ex1_1 {
    @GetMapping("/greeting")
public String greeting (@RequestParam(defaultValue = "")String name) {
        return String.format("Hello %s !", name);
    }
}
