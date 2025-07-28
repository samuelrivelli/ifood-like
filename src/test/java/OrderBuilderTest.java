import static org.junit.jupiter.api.Assertions.*;

import org.example.order.Address;
import org.example.order.Item;
import org.example.order.Order;
import org.junit.jupiter.api.Test;

public class OrderBuilderTest {

    @Test
    public void testBuildOrderSuccessfully() {
        Order order = new Order.OrderBuilder("order-100")
                .addItem(new Item("Hamburguer", 1, 20.0))
                .addItem(new Item("Batata", 1, 8.0))
                .setDeliveryAddress(new Address("Av. Paulista, 1000", "São Paulo", "01310-100"))
                .build();

        assertEquals("order-100", order.getId());
        assertEquals(2, order.getItems().size());
        assertEquals("Av. Paulista, 1000", order.getDeliveryAddress().getStreet());
    }

    @Test
    public void testBuildOrderWithoutItemsThrows() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Order.OrderBuilder("order-101")
                    .setDeliveryAddress(new Address("Av. Paulista, 1000", "São Paulo", "01310-100"))
                    .build();
        });

        assertEquals("Pedido precisa ter ao menos um item", exception.getMessage());
    }

    @Test
    public void testBuildOrderWithoutAddressThrows() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Order.OrderBuilder("order-102")
                    .addItem(new Item("Refrigerante", 2, 5.0))
                    .build();
        });

        assertEquals("Endereço de entrega obrigatório", exception.getMessage());
    }
}
