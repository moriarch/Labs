package ru.servlet;

import java.sql.*;

public class DB {
    private static String url = "jdbc:mysql://localhost/Products?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "";




    public static CardItem createCard(int number, int balance){
        CardItem card = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO cards (number, balance) VALUES (?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, number);
                    preparedStatement.setInt(2, balance);
                    preparedStatement.executeUpdate();
                }

                card = new CardItem(number, balance);

            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return card;
    }
    public static CardItem pushBalance(int number, int balance){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE cards SET balance=balance+? WHERE number=?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, balance);
                    preparedStatement.setInt(2, number);
                    preparedStatement.executeUpdate();
                }

                return getCard(number);

            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }
    public static CardItem getCard(int number){
        CardItem card = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM cards WHERE number=?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, number);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int id = resultSet.getInt("id");
                        int balance = resultSet.getInt("balance");
                        card = new CardItem(number, balance);
                        return card;
                    }
                }

            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }
}
