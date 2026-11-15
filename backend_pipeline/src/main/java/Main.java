

import Service.CustomerService;
import Service.ProductService;
import dao.CustomerDAO;
import database.DBConnection;
import generator.CustomerGenerator;
import generator.ProductImporter;
import model.Customer;
import model.Product;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws InterruptedException {



        for (int i = 0; i < 100; i++) {
            CustomerService.createCustomer();
        }

        // Import products once
        ProductService.importProducts();

        // Generate orders forever
        while (true) {

            service.OrderService.createOrder();

            Thread.sleep(1000);
        }
    }

}