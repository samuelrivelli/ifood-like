package org.example.command;

import org.example.order.Order;

public class AdvanceOrderStateCommand implements OrderCommand {
    private Order order;

    public AdvanceOrderStateCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.nextState();
    }
}
