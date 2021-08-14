package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoData {

    // == fields ==
    private static int idValue = 1;
        // tymczasowe pole do zwiększania ID, później będzie zmienione na AUTO_INCREMENT

    private final List<TodoItem> items = new ArrayList<>();

    // == constructors ==
    public TodoData() {

    }

    // == CRUDE methods ==
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
