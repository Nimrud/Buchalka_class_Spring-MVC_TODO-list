package org.example.service;

import org.example.model.TodoData;
import org.example.model.TodoItem;

public interface TodoItemService {
    void addItem(TodoItem item);
    void removeItem(int id);
    TodoItem getItem(int id);
    void updateItem(TodoItem item);
    TodoData getData();
}
