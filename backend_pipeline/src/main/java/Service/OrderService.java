package service;

import Service.CustomerService;
import Service.ProductService;
import dao.OrderDAO;
import generator.OrderGenerator;
import model.Customer;
import model.Order;
import model.Product;

public class OrderService {

    public static Order createOrder(){

        Customer customer =
                CustomerService.getRandomCustomer();

        Product product =
                ProductService.getRandomProduct();

        Order order =
                OrderGenerator.generateOrder(customer,product);

        OrderDAO.save(order);

        return order;

    }

}