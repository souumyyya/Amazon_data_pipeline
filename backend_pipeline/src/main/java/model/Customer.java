package model;

import java.time.LocalDateTime;

public class Customer {

    private int customerId;

    private String firstName;
    private String lastName;

    private String email;
    private String phone;

    private String city;
    private String state;
    private String country;

    private LocalDateTime createdAt;

    public Customer() {
    }

    // Constructor used while generating new customers
    public Customer(String firstName,
                    String lastName,
                    String email,
                    String phone,
                    String city,
                    String state,
                    String country) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // Constructor used when reading from database
    public Customer(int customerId,
                    String firstName,
                    String lastName,
                    String email,
                    String phone,
                    String city,
                    String state,
                    String country,
                    LocalDateTime createdAt) {

        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.state = state;
        this.country = country;
        this.createdAt = createdAt;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {

        return "\nCustomer {" +
                "\n customerId=" + customerId +
                ",\n firstName='" + firstName + '\'' +
                ",\n lastName='" + lastName + '\'' +
                ",\n email='" + email + '\'' +
                ",\n phone='" + phone + '\'' +
                ",\n city='" + city + '\'' +
                ",\n state='" + state + '\'' +
                ",\n country='" + country + '\'' +
                ",\n createdAt=" + createdAt +
                "\n}";
    }

}