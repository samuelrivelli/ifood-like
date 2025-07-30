
import org.example.observer.OrderObserver;
import org.example.order.Address;
import org.example.order.Item;
import org.example.order.Order;
import org.example.state.PreparingState;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class OrderObserverTest {

    @Test
    public void testObserverIsNotified() {
        Order order = new Order.OrderBuilder("test-002")
                .addItem(new Item("Item2", 2, 15.0))
                .setDeliveryAddress(new Address("Street 2", "City", "67890"))
                .build();

        OrderObserver observer = mock(OrderObserver.class);

        order.addObserver(observer);

        order.setState(new PreparingState());

        verify(observer, times(1)).update(order);

        order.nextState();

        verify(observer, times(2)).update(order);
    }
}
