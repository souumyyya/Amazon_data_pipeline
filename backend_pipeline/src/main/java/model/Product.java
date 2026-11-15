package model;

import java.time.LocalDateTime;

public class Product {

    private int productId;

    private String productName;
    private String brand;
    private String category;

    private double price;
    private int stock;

    private LocalDateTime createdAt;

    public Product() {
    }

    public Product(String productName,
                   String brand,
                   String category,
                   double price,
                   int stock) {

        this.productName = productName;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public Product(int productId,
                   String productName,
                   String brand,
                   String category,
                   double price,
                   int stock,
                   LocalDateTime createdAt) {

        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.createdAt = createdAt;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "\n productId=" + productId +
                ",\n productName='" + productName + '\'' +
                ",\n brand='" + brand + '\'' +
                ",\n category='" + category + '\'' +
                ",\n price=" + price +
                ",\n stock=" + stock +
                ",\n createdAt=" + createdAt +
                "\n}";
    }
}