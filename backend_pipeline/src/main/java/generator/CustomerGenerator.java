package generator;

import model.Customer;
import net.datafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class CustomerGenerator {

    private static final Faker faker = new Faker(new Locale("en", "IN"));
    private static final Random random = new Random();

    private static final String[] cities = {
            "Bhubaneswar",
            "Cuttack",
            "Delhi",
            "Mumbai",
            "Bangalore",
            "Hyderabad",
            "Chennai",
            "Kolkata",
            "Pune",
            "Lucknow",
            "Jaipur",
            "Ahmedabad"
    };

    private static final String[] states = {
            "Odisha",
            "Odisha",
            "Delhi",
            "Maharashtra",
            "Karnataka",
            "Telangana",
            "Tamil Nadu",
            "West Bengal",
            "Maharashtra",
            "Uttar Pradesh",
            "Rajasthan",
            "Gujarat"
    };

    public static Customer generateCustomer() {

        Customer customer = new Customer();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        customer.setFirstName(firstName);
        customer.setLastName(lastName);

        customer.setEmail(generateEmail(firstName, lastName));
        customer.setPhone(generatePhone());

        int index = random.nextInt(cities.length);

        customer.setCity(cities[index]);
        customer.setState(states[index]);
        customer.setCountry("India");

        return customer;
    }

    private static String generateEmail(String firstName, String lastName) {

        int number = random.nextInt(9000) + 1000;

        return firstName.toLowerCase() + "."
                + lastName.toLowerCase()
                + number
                + "@gmail.com";
    }

    private static String generatePhone() {

        StringBuilder phone = new StringBuilder("9");

        for (int i = 0; i < 9; i++) {
            phone.append(random.nextInt(10));
        }

        return phone.toString();
    }

}