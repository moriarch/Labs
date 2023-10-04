package org.servlet;

import java.util.ArrayList;
import java.sql.*;
import org.servlet.Product;

public class DB {
    private static String url = "jdbc:mysql://localhost/Products?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "";

    public static int removeByID(int id) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM items WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static Product selectByID(int id){
        Product product = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM items WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){


                        String name = resultSet.getString(3);
                        String category = resultSet.getString(5);
                        String description = resultSet.getString(2);
                        int price = resultSet.getInt(4);
                        product = new Product(id, name, price, category, description);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return product;
    }
    public static ArrayList selectByCategory(String categoryReq){
        ArrayList products = new ArrayList();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM items where category = '"+categoryReq+"'");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(3);
                    String category = resultSet.getString(5);
                    int price = resultSet.getInt(4);
                    Product product = new Product(id, name, price, category);
                    products.add(product);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }
    public static ArrayList selectAll() {

        ArrayList products = new ArrayList();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM items");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(3);
                    String category = resultSet.getString(5);
                    int price = resultSet.getInt(4);
                    Product product = new Product(id, name, price, category);
                    products.add(product);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }
}
