package org.example.iterator;

import org.example.order.Item;

import java.util.List;

public class OrderItemIterator implements ItemIterator {
    private final List<Item> items;
    private int currentPosition = 0;

    public OrderItemIterator(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < items.size();
    }

    @Override
    public Item next() {
        return hasNext() ? items.get(currentPosition++) : null;
    }
}

