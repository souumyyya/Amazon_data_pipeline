package dao;

import database.DBConnection;
import model.Order;

import java.sql.*;

public class OrderDAO {

    public static void save(Order order){

        String sql="""
                INSERT INTO orders
                (customer_id,
                product_id,
                quantity,
                total_amount,
                payment_method,
                order_status)
                VALUES
                (?,?,?,?,?,?)
                """;

        try(

                Connection connection=DBConnection.getConnection();

                PreparedStatement ps=
                        connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        ){

            ps.setInt(1,order.getCustomerId());
            ps.setInt(2,order.getProductId());
            ps.setInt(3,order.getQuantity());
            ps.setDouble(4,order.getTotalAmount());
            ps.setString(5,order.getPaymentMethod());
            ps.setString(6,order.getOrderStatus());

            int rows=ps.executeUpdate();

            if(rows>0){

                ResultSet rs=ps.getGeneratedKeys();

                if(rs.next()){
                    order.setOrderId(rs.getInt(1));
                }

                System.out.println(order);

            }

        }

        catch(SQLException e){
            e.printStackTrace();
        }

    }

}