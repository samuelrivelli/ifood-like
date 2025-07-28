package org.example.strategy;

import org.example.order.Address;

public interface DeliveryStrategy {
    double calculateDeliveryCost(Address address);
}
