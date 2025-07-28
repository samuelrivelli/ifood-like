package org.example.strategy;

import org.example.order.Address;

public class ExpressDelivery implements DeliveryStrategy {
    @Override
    public double calculateDeliveryCost(Address address) {
        return 20.0; // custo fixo para entrega expressa
    }
}
