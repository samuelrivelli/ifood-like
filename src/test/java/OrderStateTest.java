import static org.junit.jupiter.api.Assertions.*;

import org.example.order.Address;
import org.example.order.Item;
import org.example.order.Order;
import org.junit.jupiter.api.Test;

public class OrderStateTest {

    @Test
    public void testStateTransitions() {
        Order order = new Order.OrderBuilder("test-001")
                .addItem(new Item("Item1", 1, 10.0))
                .setDeliveryAddress(new Address("Street 1", "City", "12345"))
                .build();

        assertEquals("Recebido", order.getStateName());

        order.nextState();
        assertEquals("Preparando", order.getStateName());

        order.nextState();
        assertEquals("Enviado", order.getStateName());

        order.nextState();
        assertEquals("Entregue", order.getStateName());

        // Estado final não avança mais
        order.nextState();
        assertEquals("Entregue", order.getStateName());
    }
}
