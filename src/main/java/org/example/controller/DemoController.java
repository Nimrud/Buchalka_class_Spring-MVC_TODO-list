package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // == fields ==
    private final DemoService demoService;

    // == constructors ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // == request methods ==
    @ResponseBody
    @GetMapping("/hello")         // http://localhost:8080/TODO-list/hello
    public String hello() {
        return "hello there";
    }

    @GetMapping("welcome")
    public String welcome(Model model) {
        model.addAttribute("newUser", demoService.getHelloMessage("Mark"));
        log.info("model = {}", model);
        return "welcome";
        // dzięki użyciu kodu w klasie WebConfig, prefiks i sufiks zostaną automatycznie dodane
        // więc możemy tu wpisać samo 'welcome' zamiast '/WEB-INF/view/welcome.jsp'
    }

    // == model attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
}
