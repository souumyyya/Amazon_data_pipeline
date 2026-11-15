package model;

import java.time.LocalDateTime;

public class Order {

    private int orderId;
    private int customerId;
    private int productId;

    private int quantity;
    private double totalAmount;

    private String paymentMethod;
    private String orderStatus;

    private LocalDateTime orderDate;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "\nOrder{" +
                "\n orderId=" + orderId +
                ",\n customerId=" + customerId +
                ",\n productId=" + productId +
                ",\n quantity=" + quantity +
                ",\n totalAmount=" + totalAmount +
                ",\n paymentMethod='" + paymentMethod + '\'' +
                ",\n orderStatus='" + orderStatus + '\'' +
                ",\n orderDate=" + orderDate +
                "\n}";
    }
}