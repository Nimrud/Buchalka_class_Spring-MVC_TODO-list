package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("/hello")         // http://localhost:8080/TODO-list/hello
    public String hello() {
        return "hello there";
    }
}
