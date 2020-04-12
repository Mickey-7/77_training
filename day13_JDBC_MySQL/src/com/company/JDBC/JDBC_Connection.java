package com.company.JDBC;

import java.sql.*;

public class JDBC_Connection {
    public static void main(String[] args) {

        //jdbc
        //establish connection - download mysql connector 8.0.18
        //create statement
        //execute query
        //process result
        //close connection

        try {
            //establish connection - download mysql connector 8.0.18
            //.getConnection() will have an underline - choose surround with try/catch
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/carsDB",
                    "root",
                    "PASSWORD"
            );

            //create statement
            Statement statement = connection.createStatement();

            //execute query
            ResultSet resultSet = statement.executeQuery("select * from cars limit 7");

            //process result
            while (resultSet.next()){
                System.out.println("ID: "+resultSet.getLong("id"));
                System.out.println("Make: "+resultSet.getString("make"));
                System.out.println("Model: "+resultSet.getString("model"));
            }

            //close connection
            connection.close();

            //output
            //ID: 1
            //Make: Aston Martin
            //Model: V8 Vantage
            //ID: 2
            //Make: Plymouth
            //Model: Grand Voyager
            //ID: 3
            //Make: Porsche
            //Model: 911
            //ID: 4
            //Make: Saturn
            //Model: Ion
            //ID: 5
            //Make: Saturn
            //Model: Outlook
            //ID: 6
            //Make: Nissan
            //Model: 200SX
            //ID: 7
            //Make: Chevrolet
            //Model: Caprice

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
