import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Cars> cars = new ArrayList<Cars>();
    public static void main(String[] args) throws SQLException, IOException {

        //method to get all cars from DB
        System.out.println(getAllCars());

        //using commons-io to read READ ME.txt file content
        //FileUtils is from the commons-io maven dependency
        String content = FileUtils.readFileToString(
                new File("C:\\Users\\mmacaranas\\Downloads\\day14_Maven_JDBC\\src\\main\\READ ME.txt"),
                "UTF-8"
        );
        System.out.println(content);
    }

    public static List<Cars> getAllCars() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/carsDB",
                "root",
                "PASSWORD"
        );
        PreparedStatement getAllCarsStatement = connection.prepareStatement("select * from cars");
        ResultSet result = getAllCarsStatement.executeQuery();
        while (result.next()){
            cars.add(new Cars(result.getInt("id"),
                    result.getString("make"),
                    result.getString("model"),
                    result.getLong("year"),
                    result.getDouble("price")
            ));

        }
        connection.close();
        return cars;
    }
}
