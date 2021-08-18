package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.model.TodoData;
import org.example.model.TodoItem;
import org.example.service.TodoItemService;
import org.example.util.AttributeNames;
import org.example.util.Mappings;
import org.example.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    // == fields ==
    private final TodoItemService todoItemService;

    // == constructors ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // == handler methods ==
    @GetMapping(Mappings.ITEMS)     // http://localhost:8080/TODO-list/items
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addItem(@RequestParam(required = false, defaultValue = "-1") int id,
                          Model model) {
        TodoItem item = todoItemService.getItem(id);
        if (item == null) {
            item = new TodoItem("", "", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM, item);
        return ViewNames.ADD_ITEM;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem item) {
        log.info("todoItem from the form = {}", item);
        if (item.getId() == 0) {
            todoItemService.addItem(item);
        } else {
            todoItemService.updateItem(item);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model) {
        TodoItem item = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, item);
        return ViewNames.VIEW_ITEM;
    }
}
