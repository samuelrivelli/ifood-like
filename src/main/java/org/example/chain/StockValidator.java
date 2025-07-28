package org.example.chain;

import org.example.order.Order;

public class StockValidator extends OrderValidator {
    @Override
    public boolean validate(Order order) {
        // Simulação: estoque sempre ok
        if (next != null) {
            return next.validate(order);
        }
        return true;
    }
}
