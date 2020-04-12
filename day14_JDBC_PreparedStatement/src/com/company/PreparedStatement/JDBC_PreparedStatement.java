package com.company.PreparedStatement;

import java.sql.*;

public class JDBC_PreparedStatement {
    public static void main(String[] args) throws SQLException {

        //jdbc
        //establish connection - download mysql connector 8.0.18
        //create prepared statement
        //execute query
        //process result
        //close connection

        //establish connection - download mysql connector 8.0.18
        Connection connection = DriverManager.getConnection(
          "jdbc:mysql://127.0.0.1:3306/carsDB",
          "root",
          "PASSWORD"
        );

        //selecting a car where id=2
        //create prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement("select * from cars where id=?");
        //1st parameter : column name (represented by int) , 2nd parameter : particular data
        preparedStatement.setLong(1,2);
        //execute query
        ResultSet resultSet = preparedStatement.executeQuery();
        //process result
        while (resultSet.next()){
            //printing and creating a car object
            System.out.println(new Car(
                    resultSet.getInt("id"),
                    resultSet.getString("make"),
                    resultSet.getString("model"),
                    resultSet.getLong("year"),
                    resultSet.getDouble("price")
            ));
        }


        //selecting cars where make = toyota and model = rav4
        //create prepared statement
        PreparedStatement preparedStatement1 = connection.prepareStatement("select * from cars where make=? and model=?");
        //1st parameter : column name (represented by int) , 2nd parameter : particular data
        preparedStatement1.setString(1,"toyota");
        preparedStatement1.setString(2,"rav4");
        //execute query
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        //process result
        while (resultSet1.next()){
            //iterate on the resultSet1 as we don't know if we will have 1 or more output
            //we use fori and get the ColumnCount (output : int) of MetaData of resultSet
            for (int i = 1; i < resultSet1.getMetaData().getColumnCount()+1; i++) {
                //.getColumnName(int i) -> output : String
                String columnName = resultSet1.getMetaData().getColumnName(i);
                //.getString(int i) -> output : String
                String value = resultSet1.getString(i);
                // and print -> columnName : column name on database, value : value of given row
                System.out.println(columnName+" : "+value);
                //output -> Exception in thread "main" java.sql.SQLException: Column index out of range.
                //so make the i=1 then run
                //output
                //id : 37
                //make : Toyota
                //model : RAV4
                //year : 1998
                //to display the price -> just add 1 on the range : i < resultSet1.getMetaData().getColumnCount()+1
                //output
                //id : 37
                //make : Toyota
                //model : RAV4
                //year : 1998
                //price : 9767.15
            }
        }


        //update prepared statement - year
        PreparedStatement updateYearStatement = connection.prepareStatement("update cars set year=? where id=?");
        updateYearStatement.setString(1,"1995");
        updateYearStatement.setLong(2,2);           //alternative code : updateYearStatement.setString(2,"2");
        //storing the result as int , .executeUpdate() -> output : int
        int updateYearCount = updateYearStatement.executeUpdate();
        System.out.println("updated row : "+updateYearCount);

        //update prepared statement - price
        PreparedStatement updatePriceStatement = connection.prepareStatement("update cars set price=price+? where id=?");
        updatePriceStatement.setString(1,"500");
        updatePriceStatement.setString(2,"2");
        //storing the result as int , .executeUpdate() -> output : int
        int updatePriceCount = updatePriceStatement.executeUpdate();
        System.out.println("updated row : "+updatePriceCount);

        //notice the changing value on console for car where id = 2

        //insert prepared statement
        PreparedStatement addCarStatement = connection.prepareStatement("insert into cars(id,make,model,year,price) values(?,?,?,?,?) ");
        addCarStatement.setLong(1,101);
        addCarStatement.setString(2,"maker");
        addCarStatement.setString(3,"modeller");
        addCarStatement.setString(4,"yearEnd");
        addCarStatement.setDouble(5,7777);
        int addedRow = addCarStatement.executeUpdate();
        System.out.println("Added row : "+addedRow);
        //for multiple insert values (?,?,?,?,?),(?,?,?,?,?) or use for loop in the prepared statement
        //for same id, handle it as it will cause sql integrity exception error or use AI (auto increment in the db and removed id in the statement)


        //delete cars by make
        PreparedStatement deleteCarStatement = connection.prepareStatement("delete from cars where make=?");
        //create string for the maker
        String toBeDeleted = "maker";
        deleteCarStatement.setString(1,toBeDeleted);
        int delRow = deleteCarStatement.executeUpdate();
        System.out.println("deleted row : "+delRow);
        //adding then deleting the row we added


        //close connection
        connection.close();


    }
}
