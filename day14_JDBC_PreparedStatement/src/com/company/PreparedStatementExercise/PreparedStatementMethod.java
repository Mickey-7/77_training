package com.company.PreparedStatementExercise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PreparedStatementMethod {
    private static Scanner scanner = new Scanner(System.in);
    private static Connection connection = null;
    public static void main(String[] args) throws SQLException {

        //public static List<Car> getAllCars() {
        //    return null;
        //}
        //
        //public static List<Car> getCarByModel(String model) {
        //    return null;
        //}
        //
        //public static int addCar(Car car) {
        //    return 0;
        //}
        //
        //public static int deleteCarById(Long id) {
        //    return 0;
        //}

        connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/carsDB",
                "root",
                "PASSWORD"
        );


        System.out.println("what would you like to do?\n" +
                "1) get all cars\n" +
                "2) get car by model\n" +
                "3) add car\n" +
                "4) delete car by id\n" +
                "5) exit");
        int toDo = scanner.nextInt();

        boolean status = true;
        while (status){
            while (toDo==1){
                System.out.println("1");
                System.out.println(getAllCars()+"\n");
                System.out.println("what would you like to do?\n" +
                        "1) get all cars\n" +
                        "2) get car by model\n" +
                        "3) add car\n" +
                        "4) delete car by id\n" +
                        "5) exit");
                toDo = scanner.nextInt();
            }
            while (toDo==2){
                System.out.println("2");
                System.out.println(getCarByModel());
                System.out.println("what would you like to do?\n" +
                        "1) get all cars\n" +
                        "2) get car by model\n" +
                        "3) add car\n" +
                        "4) delete car by id\n" +
                        "5) exit");
                toDo = scanner.nextInt();
            }
            while (toDo==3){
                System.out.println("3");
                addCar();
                System.out.println("what would you like to do?\n" +
                        "1) get all cars\n" +
                        "2) get car by model\n" +
                        "3) add car\n" +
                        "4) delete car by id\n" +
                        "5) exit");
                toDo = scanner.nextInt();

            }
            while (toDo==4){
                System.out.println("4");
                deleteCarByID();
                System.out.println("what would you like to do?\n" +
                        "1) get all cars\n" +
                        "2) get car by model\n" +
                        "3) add car\n" +
                        "4) delete car by id\n" +
                        "5) exit");
                toDo = scanner.nextInt();
            }
            while (toDo==5){
                System.out.println("5");
                System.out.println("exiting program.....!");
                status=false;
                break;
            }
        }
    }

    private static void deleteCarByID() throws SQLException {
        System.out.println("enter car id to be deleted : ");
        int carId = scanner.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement(
          "delete from cars where id=?"
        );
        preparedStatement.setInt(1,carId);
        int deleteCarCount = preparedStatement.executeUpdate();
        System.out.println("Deleted row : "+deleteCarCount);

    }

    private static void addCar() throws SQLException {
        System.out.println("enter car id : ");
        int carId = scanner.nextInt();
        System.out.println("enter car make : ");
        String carMake = scanner.next();
        System.out.println("enter car model : ");
        String carModel = scanner.next();
        System.out.println("enter car year : ");
        long carYear = scanner.nextLong();
        System.out.println("enter car price : ");
        double carPrice = scanner.nextDouble();
        //create blank car object
        PreparedStatement preparedStatement = connection.prepareStatement(
          "insert into cars(id,make,model,year,price) values(?,?,?,?,?)"
        );
        preparedStatement.setInt(1,carId);
        preparedStatement.setString(2,carMake);
        preparedStatement.setString(3,carModel);
        preparedStatement.setLong(4,carYear);
        preparedStatement.setDouble(5,carPrice);
        int addedCarCount = preparedStatement.executeUpdate();
        System.out.println("Added row : "+addedCarCount);
    }

    private static List<Car> getCarByModel() throws SQLException {
        System.out.println("enter car model : ");
        String carModel = scanner.next();
        //create blank car list
        List<Car> cars = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from cars where model=?"
        );
        preparedStatement.setString(1,carModel);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //creating and adding car object to the blank list
            cars.add(new Car(
                    resultSet.getInt("id"),
                    resultSet.getString("make"),
                    resultSet.getString("model"),
                    resultSet.getLong("year"),
                    resultSet.getDouble("price")
            ));

        }
        return cars;
    }

    private static List<Car> getAllCars() throws SQLException {
        //creating blank List of car
        List<Car> cars = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from cars"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            //creating and adding car object on list of cars
            cars.add(new Car(
                    resultSet.getInt("id"),
                    resultSet.getString("make"),
                    resultSet.getString("model"),
                    resultSet.getLong("year"),
                    resultSet.getDouble("price")
            ));
        }
        return cars;
    }
}
