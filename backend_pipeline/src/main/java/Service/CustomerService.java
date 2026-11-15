package Service;

import dao.CustomerDAO;
import generator.CustomerGenerator;
import model.Customer;

public class CustomerService {

    public static Customer createCustomer() {

        Customer customer = CustomerGenerator.generateCustomer();

        CustomerDAO.save(customer);

        return customer;
    }

    public static Customer getRandomCustomer() {

        return CustomerDAO.getRandomCustomer();

    }

}