package org.example.chain;


import org.example.order.Order;

public class BalanceValidator extends OrderValidator {
    @Override
    public boolean validate(Order order) {
        // Simulação: saldo sempre ok
        if (next != null) {
            return next.validate(order);
        }
        return true;
    }
}

