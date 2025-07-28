package org.example.chain;

import org.example.order.Order;

public abstract class OrderValidator {
    protected OrderValidator next;

    public void setNext(OrderValidator next) {
        this.next = next;
    }

    public abstract boolean validate(Order order);
}

