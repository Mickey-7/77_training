package com.company.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Car {
    public static void main(String[] args) throws SQLException {

        //jdbc
        //establish connection - download mysql connector 8.0.18
        //create statement
        //execute query
        //process result
        //close connection


        //establish connection - download mysql connector 8.0.18
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/carsDB",
                "root",
                "PASSWORD"
        );
        //create statement
        Statement statement = connection.createStatement();
        //execute query
        ResultSet resultSet = statement.executeQuery("select id, make, model, year, price from cars order by id");
        //creating blank car list for storage
        List<Car> carsList = new ArrayList<>();
        //process result
        while (resultSet.next()){
            //adding the resultSet to carList
            carsList.add(new Car(
                    resultSet.getInt("id"),
                    resultSet.getString("make"),
                    resultSet.getString("model"),
                    resultSet.getLong("year"),
                    resultSet.getDouble("price")
            ));
        }
        //iteration and printing the carList
        for (Car car : carsList){
            System.out.println(car);
        }
        //close connection
        connection.close();
        //output
        //Cars = id: 1, model= V8 Vantage, make= Aston Martin, year= 2010, price= 9903.2
        //Cars = id: 2, model= Grand Voyager, make= Plymouth, year= 1994, price= 7916.82
        //Cars = id: 3, model= 911, make= Porsche, year= 2004, price= 5765.32
        //Cars = id: 4, model= Ion, make= Saturn, year= 2004, price= 2114.99
        //Cars = id: 5, model= Outlook, make= Saturn, year= 2009, price= 3400.29
        //Cars = id: 6, model= 200SX, make= Nissan, year= 1998, price= 1955.51
        //Cars = id: 7, model= Caprice, make= Chevrolet, year= 1983, price= 7867.73
        //Cars = id: 8, model= Interceptor, make= Jensen, year= 1967, price= 1885.08
        //Cars = id: 9, model= Yukon, make= GMC, year= 1998, price= 4036.65
        //Cars = id: 10, model= 3500 Club Coupe, make= GMC, year= 1996, price= 1587.49
        //Cars = id: 11, model= Diamante, make= Mitsubishi, year= 2003, price= 4999.76
        //Cars = id: 12, model= GTI, make= Volkswagen, year= 2001, price= 3623.28
        //Cars = id: 13, model= Murciélago, make= Lamborghini, year= 2003, price= 9017.13
        //Cars = id: 14, model= Grand Marquis, make= Mercury, year= 1999, price= 1122.17
        //Cars = id: 15, model= CLK-Class, make= Mercedes-Benz, year= 1998, price= 9988.25
        //Cars = id: 16, model= Fortwo, make= Smart, year= 2011, price= 1885.88
        //Cars = id: 17, model= Expedition EL, make= Ford, year= 2012, price= 5662.12
        //Cars = id: 18, model= LX, make= Lexus, year= 2007, price= 7974.75
        //Cars = id: 19, model= Patriot, make= Jeep, year= 2007, price= 7100.78
        //Cars = id: 20, model= Transit Connect, make= Ford, year= 2010, price= 5391.1
        //Cars = id: 21, model= Lumina APV, make= Chevrolet, year= 1992, price= 2323.98
        //Cars = id: 22, model= Outlander, make= Mitsubishi, year= 2006, price= 5051.34
        //Cars = id: 23, model= A5, make= Audi, year= 2008, price= 2970.38
        //Cars = id: 24, model= xB, make= Scion, year= 2006, price= 2968.41
        //Cars = id: 25, model= 7 Series, make= BMW, year= 2007, price= 6892.69
        //Cars = id: 26, model= Sentra, make= Nissan, year= 2004, price= 5743.48
        //Cars = id: 27, model= Suburban 1500, make= Chevrolet, year= 2011, price= 5053.23
        //Cars = id: 28, model= MDX, make= Acura, year= 2005, price= 5798.64
        //Cars = id: 29, model= Aerostar, make= Ford, year= 1990, price= 9005.74
        //Cars = id: 30, model= EV1, make= GMC, year= 1999, price= 5369.55
        //Cars = id: 31, model= H1, make= Hummer, year= 1995, price= 8487.29
        //Cars = id: 32, model= Envoy XL, make= GMC, year= 2006, price= 6991.48
        //Cars = id: 33, model= Alero, make= Oldsmobile, year= 2002, price= 4798.27
        //Cars = id: 34, model= Monte Carlo, make= Chevrolet, year= 1997, price= 4823.38
        //Cars = id: 35, model= 200, make= Chrysler, year= 2012, price= 3183.77
        //Cars = id: 36, model= Camaro, make= Chevrolet, year= 1973, price= 3505.88
        //Cars = id: 37, model= RAV4, make= Toyota, year= 1998, price= 9767.15
        //Cars = id: 38, model= 760, make= BMW, year= 2003, price= 3689.13
        //Cars = id: 39, model= Firebird, make= Pontiac, year= 1994, price= 5716.63
        //Cars = id: 40, model= Eclipse, make= Mitsubishi, year= 2004, price= 4969.78
        //Cars = id: 42, model= Laser, make= Ford, year= 1985, price= 2996.88
        //Cars = id: 43, model= Montero, make= Mitsubishi, year= 1994, price= 1403.34
        //Cars = id: 44, model= Vitara, make= Suzuki, year= 2000, price= 6981.31
        //Cars = id: 45, model= 98, make= Oldsmobile, year= 1994, price= 8204.44
        //Cars = id: 46, model= Grand Am, make= Pontiac, year= 1997, price= 9681.99
        //Cars = id: 47, model= 1 Series, make= BMW, year= 2010, price= 1760.71
        //Cars = id: 48, model= Tribute, make= Mazda, year= 2010, price= 2062.36
        //Cars = id: 49, model= Camaro, make= Chevrolet, year= 2011, price= 6627.1
        //Cars = id: 50, model= Intrepid, make= Dodge, year= 1996, price= 7867.83
        //Cars = id: 51, model= Sephia, make= Kia, year= 1995, price= 3893.19
        //Cars = id: 52, model= Mazda6 5-Door, make= Mazda, year= 2006, price= 1609.22
        //Cars = id: 53, model= rio, make= Volkswagen, year= 1999, price= 4600.04
        //Cars = id: 54, model= Jetta, make= Volkswagen, year= 2007, price= 2078.92
        //Cars = id: 55, model= Paseo, make= Toyota, year= 1995, price= 8047.65
        //Cars = id: 56, model= T100, make= Toyota, year= 1995, price= 9182.22
        //Cars = id: 57, model= Savana 2500, make= GMC, year= 1998, price= 2958.93
        //Cars = id: 58, model= i-Series, make= Isuzu, year= 2007, price= 9362.61
        //Cars = id: 59, model= Neon, make= Plymouth, year= 1995, price= 2578.32
        //Cars = id: 60, model= VUE, make= Saturn, year= 2005, price= 6714.55
        //Cars = id: 61, model= Avalanche, make= Chevrolet, year= 2008, price= 1515.66
        //Cars = id: 62, model= Stratus, make= Dodge, year= 1996, price= 1583.01
        //Cars = id: 63, model= Mirage, make= Mitsubishi, year= 1995, price= 7860.83
        //Cars = id: 64, model= Tiburon, make= Hyundai, year= 1999, price= 7674.05
        //Cars = id: 65, model= Eclipse, make= Mitsubishi, year= 1996, price= 8105.9
        //Cars = id: 66, model= Avalanche, make= Chevrolet, year= 2010, price= 5958.96
        //Cars = id: 67, model= Lynx, make= Mercury, year= 1987, price= 1326.62
        //Cars = id: 68, model= Tempest, make= Pontiac, year= 1967, price= 2680.01
        //Cars = id: 69, model= Tiburon, make= Hyundai, year= 2006, price= 9960.11
        //Cars = id: 70, model= 240, make= Volvo, year= 1993, price= 9773.55
        //Cars = id: 71, model= 5 Series, make= BMW, year= 2003, price= 1976.47
        //Cars = id: 73, model= Envoy, make= GMC, year= 1998, price= 5326.51
        //Cars = id: 74, model= Celica, make= Toyota, year= 1993, price= 2680.55
        //Cars = id: 75, model= Maxima, make= Nissan, year= 2008, price= 7267.58
        //Cars = id: 76, model= 650, make= BMW, year= 2006, price= 4756.87
        //Cars = id: 77, model= Town Car, make= Lincoln, year= 2011, price= 1185.32
        //Cars = id: 78, model= 3 Series, make= BMW, year= 1995, price= 3357.64
        //Cars = id: 79, model= S4, make= Audi, year= 2004, price= 9739.56
        //Cars = id: 80, model= California, make= Ferrari, year= 2010, price= 5551.99
        //Cars = id: 81, model= Touareg, make= Volkswagen, year= 2004, price= 8725.46
        //Cars = id: 82, model= Liberty, make= Jeep, year= 2012, price= 1812.5
        //Cars = id: 83, model= GranSport, make= Maserati, year= 2005, price= 3688.04
        //Cars = id: 84, model= G5, make= Pontiac, year= 2009, price= 6441.38
        //Cars = id: 85, model= A8, make= Audi, year= 2002, price= 1765.92
        //Cars = id: 86, model= Pathfinder, make= Nissan, year= 2002, price= 1280.64
        //Cars = id: 87, model= Terrain, make= GMC, year= 2012, price= 5424.3
        //Cars = id: 88, model= A3, make= Audi, year= 2007, price= 1029.17
        //Cars = id: 89, model= 90, make= Audi, year= 1994, price= 2558.31
        //Cars = id: 90, model= MX-3, make= Mazda, year= 1995, price= 2958.25
        //Cars = id: 91, model= Cherokee, make= Jeep, year= 1998, price= 2008.67
        //Cars = id: 92, model= Previa, make= Toyota, year= 1991, price= 6175.52
        //Cars = id: 93, model= Grand Marquis, make= Mercury, year= 2009, price= 4701.15
        //Cars = id: 94, model= Freestyle, make= Ford, year= 2007, price= 8872.59
        //Cars = id: 95, model= F350, make= Ford, year= 1996, price= 7420.62
        //Cars = id: 96, model= Mazda3, make= Mazda, year= 2010, price= 7709.41
        //Cars = id: 97, model= Ranger, make= Ford, year= 1997, price= 5170.67
        //Cars = id: 98, model= Safari, make= GMC, year= 1997, price= 2702.31
        //Cars = id: 99, model= Outlook, make= Saturn, year= 2007, price= 9284.29
        //Cars = id: 100, model= G-Class, make= Mercedes-Benz, year= 2011, price= 2981.87
        //
        //Process finished with exit code 0
    }
}
