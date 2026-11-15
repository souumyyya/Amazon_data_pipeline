package generator;

import model.Customer;
import model.Order;
import model.Product;

import java.util.Random;

public class OrderGenerator {

    private static final Random random = new Random();

    private static final String[] PAYMENT_METHODS = {
            "UPI",
            "Credit Card",
            "Debit Card",
            "Net Banking",
            "Cash On Delivery"
    };

    private static final String[] ORDER_STATUS = {
            "Processing",
            "Packed",
            "Shipped",
            "Delivered"
    };

    public static Order generateOrder(Customer customer, Product product) {

        Order order = new Order();

        int quantity = random.nextInt(5) + 1;

        order.setCustomerId(customer.getCustomerId());
        order.setProductId(product.getProductId());

        order.setQuantity(quantity);

        order.setTotalAmount(quantity * product.getPrice());

        order.setPaymentMethod(
                PAYMENT_METHODS[random.nextInt(PAYMENT_METHODS.length)]
        );

        order.setOrderStatus(
                ORDER_STATUS[random.nextInt(ORDER_STATUS.length)]
        );

        return order;
    }

}