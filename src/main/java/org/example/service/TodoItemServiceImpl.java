package org.example.service;

import lombok.NonNull;
import org.example.model.TodoData;
import org.example.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService{

    // == fields ==
    private final TodoData todoData = new TodoData();

    // == public methods ==
    @Override
    public void addItem(@NonNull TodoItem item) {
        todoData.addItem(item);
    }

    @Override
    public void removeItem(int id) {
        todoData.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return todoData.getItem(id);
    }

    @Override
    public void updateItem(@NonNull TodoItem item) {
        todoData.updateItem(item);
    }

    @Override
    public TodoData getData() {
        return todoData;
    }
}
