package dao;

import database.DBConnection;
import model.Product;

import java.sql.*;

public class ProductDAO {

    public static void save(Product product){

        String sql="""
                INSERT INTO products
                (product_name,brand,category,price,stock)
                VALUES
                (?,?,?,?,?)
                """;

        try(
                Connection connection= DBConnection.getConnection();

                PreparedStatement ps=
                        connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        ){

            ps.setString(1,product.getProductName());
            ps.setString(2,product.getBrand());
            ps.setString(3,product.getCategory());
            ps.setDouble(4,product.getPrice());
            ps.setInt(5,product.getStock());

            int rows=ps.executeUpdate();

            if(rows>0){

                ResultSet rs=ps.getGeneratedKeys();

                if(rs.next()){
                    product.setProductId(rs.getInt(1));
                }

                System.out.println(product);

            }

        }

        catch(SQLException e){
            e.printStackTrace();
        }

    }

    public static Product getRandomProduct(){

        String sql="""
                SELECT *
                FROM products
                ORDER BY RAND()
                LIMIT 1
                """;

        try(
                Connection connection=DBConnection.getConnection();

                PreparedStatement ps=
                        connection.prepareStatement(sql);

        ){

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                Product product=new Product();

                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setBrand(rs.getString("brand"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));

                Timestamp timestamp=rs.getTimestamp("created_at");

                if(timestamp!=null){
                    product.setCreatedAt(timestamp.toLocalDateTime());
                }

                return product;

            }

        }

        catch(SQLException e){
            e.printStackTrace();
        }

        return null;

    }

}