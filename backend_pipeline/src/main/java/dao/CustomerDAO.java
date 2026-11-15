package dao;

import database.DBConnection;
import model.Customer;

import java.sql.*;

public class CustomerDAO {

    public static void save(Customer customer) {

        String sql = """
                INSERT INTO customers
                (first_name,last_name,email,phone,city,state,country)
                VALUES
                (?,?,?,?,?,?,?)
                """;

        try (
                Connection connection = DBConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getCity());
            ps.setString(6, customer.getState());
            ps.setString(7, customer.getCountry());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    customer.setCustomerId(rs.getInt(1));
                }

                System.out.println("Customer Inserted Successfully");
                System.out.println(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Customer getRandomCustomer() {

        String sql = """
                SELECT *
                FROM customers
                ORDER BY RAND()
                LIMIT 1
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Customer customer = new Customer();

                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setCountry(rs.getString("country"));

                Timestamp timestamp = rs.getTimestamp("created_at");

                if (timestamp != null) {
                    customer.setCreatedAt(timestamp.toLocalDateTime());
                }

                return customer;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}