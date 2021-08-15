package org.example.controller;

import org.example.model.TodoData;
import org.example.util.Mappings;
import org.example.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    // == handler methods ==
    @GetMapping(Mappings.ITEMS)     // http://localhost:8080/TODO-list/items
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
