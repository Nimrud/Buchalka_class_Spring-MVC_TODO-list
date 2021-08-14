package org.example.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {
    // ta klasa reprezentuje wewnętrzną (w pamięci komputera) bazę danych

    // == fields ==
    private static int idValue = 1;
        // tymczasowe pole do zwiększania ID, później będzie zmienione na AUTO_INCREMENT

    private final List<TodoItem> items = new ArrayList<>();
        // final - po to, aby lista była niezmienna (immutable)
        // czyli aby nie można było przypisać do nie innej ArrayList

    // == constructors ==
    public TodoData() {

        // dodanie tymczasowych danych do testowania:
        addItem(new TodoItem("first", "first details", LocalDate.now()));
        addItem(new TodoItem("second", "second details", LocalDate.now()));
        addItem(new TodoItem("third", "third details", LocalDate.now()));
    }

    // == public methods ==
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
            // aby inne klasy mające dostęp do tej nie były w stanie modyfikować listy
    }

    public void addItem(@NonNull TodoItem item) {
        // @NonNull z Lomboka, a nie Springa
        if (!items.contains(item)) {
            item.setId(idValue);
            items.add(item);
            idValue++;
        }
    }

    public void removeItem(int id) {
        ListIterator<TodoItem> itemIterator = items.listIterator();
        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();
            if (item.getId() == id) {
                itemIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem itemToUpdate) {
        ListIterator<TodoItem> itemIterator = items.listIterator();
        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();
            if (item.equals(itemToUpdate)) {
                // metoda .equals() jest generowana przez Lomboka w klasie TodoItem
                itemIterator.set(itemToUpdate);
                break;
            }
        }
    }
}
