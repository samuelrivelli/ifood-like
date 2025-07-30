import org.example.iterator.OrderHistory;
import org.example.order.Address;
import org.example.order.Item;
import org.example.order.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderMementoTest {

    @Test
    public void testUndoOrderItems() {
        Order order = new Order.OrderBuilder("999")
                .addItem(new Item("Mouse", 1, 20.0))
                .setDeliveryAddress(new Address("Rua X", "Cidade Y", "00000-000"))
                .build();

        OrderHistory history = new OrderHistory();

        // Primeiro estado salvo com 1 item
        history.saveState(order.saveToMemento());

        // Adiciona segundo item e salva estado
        order.addItem(new Item("Teclado", 1, 35.0));
        history.saveState(order.saveToMemento());

        // Adiciona terceiro item (sem salvar)
        order.addItem(new Item("Monitor", 1, 150.0));

        assertEquals(3, order.getItems().size());

        // Desfaz monitor
        order.restoreFromMemento(history.undo());
        assertEquals(2, order.getItems().size());

        // Desfaz teclado
        order.restoreFromMemento(history.undo());
        assertEquals(1, order.getItems().size());

        // Verifica se o item "Mouse" ainda está lá
        assertEquals("Mouse", order.getItems().get(0).getName());
    }
}
