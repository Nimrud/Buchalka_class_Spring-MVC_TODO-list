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

    @GetMapping("welcome")
    public String welcome() {
        return "welcome";
        // dzięki użyciu kodu w klasie WebConfig, prefiks i sufiks zostaną automatycznie dodane
        // więc możemy tu wpisać samo 'welcome' zamiast '/WEB-INF/view/welcome.jsp'
    }
}
