import org.example.iterator.ItemIterator;
import org.example.order.Address;
import org.example.order.Item;
import org.example.order.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderIteratorTest {

    @Test
    public void testIteratorOverItems() {
        Address address = new Address("Rua A", "Cidade X", "12345-678");

        Order order = new Order.OrderBuilder("123")
                .addItem(new Item("Teclado", 1, 35.0))
                .addItem(new Item("Mouse", 2, 27.0))
                .addItem(new Item("Monitor", 1, 20.0))
                .setDeliveryAddress(address)
                .build();

        ItemIterator iterator = order.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Teclado", iterator.next().getName());

        assertTrue(iterator.hasNext());
        assertEquals("Mouse", iterator.next().getName());

        assertTrue(iterator.hasNext());
        assertEquals("Monitor", iterator.next().getName());

        assertFalse(iterator.hasNext());
    }
}
