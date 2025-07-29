import org.example.decorator.GiftWrapDecorator;
import org.example.decorator.InsuranceDecorator;
import org.example.decorator.OrderComponent;
import org.example.order.Address;
import org.example.order.Item;
import org.example.order.Order;
import org.example.strategy.StandardDelivery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderDecoratorTest {

    @Test
    public void testOrderWithoutDecorator() {
        Order order = new Order.OrderBuilder("001")
                .addItem(new Item("Produto A", 1, 50.0))
                .setDeliveryAddress(new Address("Rua X", "Cidade Y", "00000"))
                .build();

        order.setDeliveryStrategy(new StandardDelivery());

        assertEquals(10.0, order.calculateDeliveryCost());
        assertEquals("Pedido 001 com 1 itens", order.getDescription());
    }

    @Test
    public void testOrderWithGiftWrapDecorator() {
        Order order = new Order.OrderBuilder("002")
                .addItem(new Item("Produto B", 2, 100.0))
                .setDeliveryAddress(new Address("Rua Y", "Cidade Z", "11111"))
                .build();

        order.setDeliveryStrategy(new StandardDelivery());

        OrderComponent decoratedOrder = new GiftWrapDecorator(order);

        assertEquals(15.0, decoratedOrder.calculateDeliveryCost());
        assertEquals("Pedido 002 com 2 itens, com embalagem para presente", decoratedOrder.getDescription());
    }

    @Test
    public void testOrderWithInsuranceDecorator() {
        Order order = new Order.OrderBuilder("003")
                .addItem(new Item("Produto C", 3, 200.0))
                .setDeliveryAddress(new Address("Rua Z", "Cidade W", "22222"))
                .build();

        order.setDeliveryStrategy(new StandardDelivery());

        OrderComponent decoratedOrder = new InsuranceDecorator(order);

        assertEquals(20.0, decoratedOrder.calculateDeliveryCost());
        assertEquals("Pedido 003 com 3 itens, com seguro", decoratedOrder.getDescription());
    }

    @Test
    public void testOrderWithMultipleDecorators() {
        Order order = new Order.OrderBuilder("004")
                .addItem(new Item("Produto D", 1, 150.0))
                .setDeliveryAddress(new Address("Rua A", "Cidade B", "33333"))
                .build();

        order.setDeliveryStrategy(new StandardDelivery());

        OrderComponent decoratedOrder = new GiftWrapDecorator(order);
        decoratedOrder = new InsuranceDecorator(decoratedOrder);

        assertEquals(25.0, decoratedOrder.calculateDeliveryCost());
        assertEquals("Pedido 004 com 1 itens, com embalagem para presente, com seguro", decoratedOrder.getDescription());
    }
}
