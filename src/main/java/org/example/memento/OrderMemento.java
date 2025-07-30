package org.example.memento;

import org.example.order.Item;

import java.util.ArrayList;
import java.util.List;

public class OrderMemento {
    private final List<Item> items;

    public OrderMemento(List<Item> items) {
        this.items = new ArrayList<>(items);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
