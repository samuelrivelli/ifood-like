

import static org.junit.jupiter.api.Assertions.*;

import org.example.chain.BalanceValidator;
import org.example.chain.StockValidator;
import org.example.order.Address;
import org.example.order.Item;
import org.example.order.Order;
import org.junit.jupiter.api.Test;

public class OrderValidatorTest {

    @Test
    public void testChainValidationSuccess() {
        Order order = new Order.OrderBuilder("test-004")
                .addItem(new Item("Item4", 2, 12.0))
                .setDeliveryAddress(new Address("Street 4", "City", "98765"))
                .build();

        StockValidator stockValidator = new StockValidator();
        BalanceValidator balanceValidator = new BalanceValidator();

        stockValidator.setNext(balanceValidator);

        boolean result = stockValidator.validate(order);

        assertTrue(result);
    }
}
