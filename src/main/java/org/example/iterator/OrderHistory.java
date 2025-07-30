package org.example.iterator;

import org.example.memento.OrderMemento;

import java.util.Stack;

public class OrderHistory {
    private final Stack<OrderMemento> history = new Stack<>();

    public void saveState(OrderMemento memento) {
        history.push(memento);
    }

    public OrderMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }

    public boolean hasHistory() {
        return !history.isEmpty();
    }
}
