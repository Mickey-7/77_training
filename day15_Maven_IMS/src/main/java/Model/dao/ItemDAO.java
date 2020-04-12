package Model.dao;


import Model.domain.Item;


import java.sql.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//JDBC - get data from IMSDB - will be called by ItemService
public class ItemDAO {
    private static Connection connection = null;

    //constructor invoking connection to DB
    public ItemDAO() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/IMSDB",
                "root",
                "PASSWORD"
        );
    }

    //addItem
    public void addItem(Item item) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into items(id,name,price,active,dateAdded,timeAdded,dateUpdated,timeUpdated) values(?,?,?,?,?,?,?,?)"
        );
        preparedStatement.setLong(1,item.getId());
        preparedStatement.setString(2,item.getName());
        preparedStatement.setDouble(3,item.getPrice());
        preparedStatement.setBoolean(4,true);
        //Date (java.sql)
        //.valueOf(String s) -> output Date
        //LocalDate (java.time)
        //.now() -> output -> LocalDate
        //same goes for time
        preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));
        preparedStatement.setTime(6, Time.valueOf(LocalTime.now() ));
        preparedStatement.setDate(7, Date.valueOf(LocalDate.now()));
        preparedStatement.setTime(8, Time.valueOf(LocalTime.now()));
        int addedRowCount = preparedStatement.executeUpdate();
        System.out.println("Added row count : "+addedRowCount);
    }

    //viewItem by id
    public List<Item> viewItemByID(Long id) throws SQLException {
        //create blank list of item
        List<Item> items = new ArrayList<Item>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from items where id=? and active=?"
        );
        preparedStatement.setLong(1,id);
        preparedStatement.setBoolean(2,true);
        //we are using resultSet for multiple displaying of data from DB
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
//            //notice the i=1 and range i < resultSet.getMetaDate().getColumnCount()+1
//            for (int i = 1; i < resultSet.getMetaData().getColumnCount()+1; i++) {
//                //create String for column name storage
//                //.getColumnName(int i) -> output : String
//                String columnName = resultSet.getMetaData().getColumnName(i);
//                //create String for value of cell storage
//                //.getString(int i) -> output : String
//                String value = resultSet.getString(i);
//                System.out.println(columnName+" : "+value);
//            }
//            //the for loop code above is used to display column names with corresponding values
//            //output
//            //id : 2
//            //name : Geba
//            //price : 8.76
//            //active : 1
//            //dateAdded : 2020-03-01
//            //timeAdded : 02:10:38
//            //dateUpdated : 2019-08-15
//            //timeUpdated : 08:56:30
            items.add(new Item(
                    //we want add the item to the blank list we created
                    //so create item object inside the .add() method
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"),
                    resultSet.getBoolean("active"),
                    //.getDate(String s) -> output : Date
                    //string input is the column name, Date for sql data type
                    //.toLocalDate() -> output : LocalDate
                    // from Date (sql) to .toLocalDate (java)
                    //same application for the time
                    resultSet.getDate("dateAdded").toLocalDate(),
                    resultSet.getTime("timeAdded").toLocalTime(),
                    resultSet.getDate("dateUpdated").toLocalDate(),
                    resultSet.getTime("timeUpdated").toLocalTime()
            ));
        }
        return items;
    }

    //removeItem set active to false
    public void removeItem(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update items set active=? where id=?"
        );
        preparedStatement.setBoolean(1,false);
        preparedStatement.setLong(2,id);
        //create an int to set the count of removed Item
        int removeItemCount = preparedStatement.executeUpdate();
        System.out.println("removed (set to false) row count "+removeItemCount);
    }

    //viewItem by name
    public List<Item> viewItemByName(String name) throws SQLException {
        //create blank list of Item
        List<Item> items = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from items where name=?"
        );
        preparedStatement.setString(1,name);
        ResultSet resultSet =preparedStatement.executeQuery();
        while (resultSet.next()){
            items.add(
                    new Item(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getDouble("price"),
                            resultSet.getBoolean("active"),
                            resultSet.getDate("dateAdded").toLocalDate(),
                            resultSet.getTime("timeAdded").toLocalTime(),
                            resultSet.getDate("dateUpdated").toLocalDate(),
                            resultSet.getTime("timeUpdated").toLocalTime()
                    )
            );
        }
        return items;
    }

    //getPriceSummary - show average price, highest - we use Map<K,V> for Average: double, Max: double, Min: double
    public Map<String,Double> getPriceSummary() throws SQLException {
        //create blank Map of item for the storage of price summary
        Map<String,Double> price = new HashMap<>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                    //in the min(price) as Min -> Min is the alias : which will hold the value when put into map
                "select min(price) as Min, max(price) as Max, avg(price) as Avg from items"
        );

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            //key is the category price if Minimum, Maximum or Average, value ids the alias from above
            price.put("Minimum",resultSet.getDouble("Min"));
            price.put("Maximum",resultSet.getDouble("max"));
            price.put("Average",resultSet.getDouble("Avg"));
        }
        return price;
    }

//    //not an option - sort by price highest to lowest
//    public List<Item> getOriginalPriceSummary() throws SQLException {
//        //create blank list of Item for storage of sorted data
//        List<Item> items = new ArrayList<>();
//        PreparedStatement preparedStatement = connection.prepareStatement(
//                "select * from items"
//        );
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()){
//            items.add(
//              new Item(
//                      resultSet.getLong("id"),
//                      resultSet.getString("name"),
//                      resultSet.getDouble("price"),
//                      resultSet.getBoolean("active"),
//                      resultSet.getDate("dateAdded").toLocalDate(),
//                      resultSet.getTime("timeAdded").toLocalTime(),
//                      resultSet.getDate("dateUpdated").toLocalDate(),
//                      resultSet.getTime("timeUpdated").toLocalTime()
//              )
//            );
//        }
//
////        //highest to lowest
////        items.sort((item, t1) -> (int) (t1.getPrice()-item.getPrice()));
////        //output
////        //Exception in thread "main" java.lang.IllegalArgumentException: Comparison method violates its general contract!
////        //link solution - https://stackoverflow.com/questions/9469308/java-error-comparison-method-violates-its-general-contract
////        //use Double.compareTo()
////        //output
////        //[Item{id=51, name='Browsezoom', price=9.91, active=true, dateAdded=2019-10-10, timeAdded=14:49:36, dateUpdated=2019-07-08, timeUpdated=17:48:01}, Item{id=5, name='Meezzy', price=9.7, active=true, dateAdded=2020-01-14, timeAdded=07:39:41, dateUpdated=2019-08-18, timeUpdated=16:55:29}, Item{id=18, name='Flashspan', price=9.59, active=false, dateAdded=2019-09-11, timeAdded=16:09:33, dateUpdated=2020-03-05, timeUpdated=13:28:05}, Item{id=97, name='Pixoboo', price=9.55, active=true, dateAdded=2019-05-07, timeAdded=13:49:44, dateUpdated=2019-08-01, timeUpdated=08:18:32}, Item{id=28, name='Vimbo', price=9.45, active=true, dateAdded=2019-07-31, timeAdded=10:44:41, dateUpdated=2019-04-14, timeUpdated=17:59:52}, Item{id=43, name='Yambee', price=9.38, active=false, dateAdded=2020-02-04, timeAdded=12:10:03, dateUpdated=2019-12-09, timeUpdated=13:26:45}, Item{id=36, name='Skynoodle', price=9.18, active=true, dateAdded=2019-11-30, timeAdded=14:12:45, dateUpdated=2019-12-20, timeUpdated=10:58:50}, Item{id=11, name='Tanoodle', price=9.16, active=false, dateAdded=2020-02-17, timeAdded=11:28, dateUpdated=2019-04-27, timeUpdated=18:05:11}, Item{id=25, name='Centimia', price=9.08, active=false, dateAdded=2019-10-23, timeAdded=13:59:42, dateUpdated=2019-05-31, timeUpdated=10:29:22}, Item{id=82, name='Flashdog', price=8.97, active=true, dateAdded=2019-12-25, timeAdded=08:58:06, dateUpdated=2020-02-02, timeUpdated=11:16:26}, Item{id=49, name='Skalith', price=8.92, active=true, dateAdded=2019-08-01, timeAdded=08:57:20, dateUpdated=2019-10-20, timeUpdated=11:45:27}, Item{id=56, name='Gevee', price=8.81, active=true, dateAdded=2020-01-24, timeAdded=17:28:30, dateUpdated=2020-03-25, timeUpdated=07:55:54}, Item{id=45, name='Podcat', price=8.65, active=true, dateAdded=2020-03-07, timeAdded=17:19:02, dateUpdated=2019-09-06, timeUpdated=18:45:17}, Item{id=6, name='Voonder', price=8.38, active=false, dateAdded=2019-11-15, timeAdded=11:08:35, dateUpdated=2019-10-02, timeUpdated=18:16:45}, Item{id=30, name='Rhynyx', price=8.36, active=false, dateAdded=2020-01-19, timeAdded=10:24:12, dateUpdated=2019-11-06, timeUpdated=09:36:31}, Item{id=40, name='Eare', price=8.22, active=false, dateAdded=2019-05-15, timeAdded=12:18:45, dateUpdated=2019-08-03, timeUpdated=17:35:44}, Item{id=77, name='Skivee', price=8.19, active=false, dateAdded=2019-04-30, timeAdded=13:15:36, dateUpdated=2019-10-26, timeUpdated=17:01:45}, Item{id=93, name='Divape', price=8.0, active=true, dateAdded=2020-03-31, timeAdded=16:37:28, dateUpdated=2019-05-04, timeUpdated=17:53:43}, Item{id=96, name='Zoomcast', price=7.92, active=false, dateAdded=2019-11-05, timeAdded=17:03:24, dateUpdated=2019-12-03, timeUpdated=11:34:53}, Item{id=15, name='Skibox', price=7.91, active=false, dateAdded=2019-09-25, timeAdded=18:21:36, dateUpdated=2019-09-25, timeUpdated=17:37:27}, Item{id=84, name='Oozz', price=7.8, active=true, dateAdded=2019-08-10, timeAdded=16:58:23, dateUpdated=2019-05-15, timeUpdated=13:49:02}, Item{id=59, name='Viva', price=7.74, active=false, dateAdded=2019-08-06, timeAdded=17:50:12, dateUpdated=2019-09-29, timeUpdated=12:06:55}, Item{id=3, name='Voolith', price=7.73, active=true, dateAdded=2020-03-02, timeAdded=11:55:48, dateUpdated=2019-04-24, timeUpdated=17:23:12}, Item{id=4, name='Yakidoo', price=7.65, active=true, dateAdded=2019-05-03, timeAdded=11:39:39, dateUpdated=2020-02-12, timeUpdated=08:01:39}, Item{id=7, name='Feedfish', price=7.64, active=true, dateAdded=2019-11-11, timeAdded=08:58:25, dateUpdated=2020-02-26, timeUpdated=11:09:24}, Item{id=46, name='Trupe', price=7.58, active=false, dateAdded=2019-07-05, timeAdded=17:27:46, dateUpdated=2020-01-28, timeUpdated=15:00:40}, Item{id=63, name='Voonder', price=7.52, active=true, dateAdded=2020-03-13, timeAdded=16:54:58, dateUpdated=2019-11-15, timeUpdated=08:54:23}, Item{id=68, name='Omba', price=7.5, active=true, dateAdded=2019-06-20, timeAdded=10:37:29, dateUpdated=2019-08-14, timeUpdated=09:42:21}, Item{id=17, name='Wordware', price=7.4, active=true, dateAdded=2019-10-01, timeAdded=13:40:36, dateUpdated=2019-12-24, timeUpdated=17:23:54}, Item{id=81, name='Avaveo', price=7.34, active=true, dateAdded=2019-04-26, timeAdded=09:36:06, dateUpdated=2019-10-09, timeUpdated=13:54:15}, Item{id=89, name='Meezzy', price=7.26, active=true, dateAdded=2019-04-23, timeAdded=15:19:58, dateUpdated=2019-08-20, timeUpdated=09:30:10}, Item{id=57, name='Feedfire', price=7.21, active=false, dateAdded=2019-09-15, timeAdded=15:18:54, dateUpdated=2019-12-15, timeUpdated=16:32:49}, Item{id=24, name='Yotz', price=7.12, active=true, dateAdded=2019-11-11, timeAdded=16:43:16, dateUpdated=2020-03-01, timeUpdated=17:29:44}, Item{id=21, name='Talane', price=7.07, active=true, dateAdded=2019-06-24, timeAdded=15:09:33, dateUpdated=2019-09-15, timeUpdated=12:21:16}, Item{id=50, name='Quamba', price=6.55, active=true, dateAdded=2019-05-20, timeAdded=13:31:35, dateUpdated=2019-10-22, timeUpdated=10:31:16}, Item{id=85, name='Quinu', price=6.37, active=false, dateAdded=2020-01-16, timeAdded=18:05:26, dateUpdated=2019-04-29, timeUpdated=12:27:48}, Item{id=48, name='Blogspan', price=6.35, active=false, dateAdded=2019-11-17, timeAdded=12:36:13, dateUpdated=2020-01-22, timeUpdated=11:53:17}, Item{id=14, name='Layo', price=6.34, active=true, dateAdded=2019-05-01, timeAdded=13:12:08, dateUpdated=2019-07-05, timeUpdated=14:54:32}, Item{id=39, name='Livetube', price=6.3, active=true, dateAdded=2019-05-18, timeAdded=11:03:12, dateUpdated=2020-01-20, timeUpdated=18:37:40}, Item{id=88, name='Zoonder', price=6.17, active=false, dateAdded=2019-08-17, timeAdded=17:00:25, dateUpdated=2019-04-05, timeUpdated=13:05:41}, Item{id=38, name='Twimm', price=6.16, active=true, dateAdded=2019-05-24, timeAdded=16:10:16, dateUpdated=2020-01-30, timeUpdated=14:47:35}, Item{id=94, name='Thoughtstorm', price=6.1, active=true, dateAdded=2019-11-03, timeAdded=19:08:15, dateUpdated=2020-03-14, timeUpdated=09:35:15}, Item{id=47, name='Topicblab', price=6.09, active=true, dateAdded=2019-07-25, timeAdded=08:16:52, dateUpdated=2019-08-30, timeUpdated=16:06:19}, Item{id=75, name='Zazio', price=6.01, active=false, dateAdded=2019-06-12, timeAdded=10:51:43, dateUpdated=2019-11-14, timeUpdated=09:46:49}, Item{id=23, name='Demimbu', price=5.89, active=true, dateAdded=2019-10-31, timeAdded=12:39:41, dateUpdated=2019-12-14, timeUpdated=18:12:56}, Item{id=32, name='Eayo', price=5.76, active=true, dateAdded=2019-05-04, timeAdded=11:07:59, dateUpdated=2020-01-20, timeUpdated=15:33:44}, Item{id=13, name='Feedfire', price=5.6, active=false, dateAdded=2019-08-19, timeAdded=10:36:25, dateUpdated=2019-09-05, timeUpdated=15:44:50}, Item{id=76, name='Youfeed', price=5.47, active=false, dateAdded=2020-03-22, timeAdded=18:13:32, dateUpdated=2019-09-30, timeUpdated=12:33:34}, Item{id=95, name='Meezzy', price=5.44, active=false, dateAdded=2019-10-03, timeAdded=10:49:05, dateUpdated=2019-12-17, timeUpdated=07:57:22}, Item{id=41, name='Youtags', price=5.35, active=true, dateAdded=2020-03-20, timeAdded=13:36:55, dateUpdated=2019-05-31, timeUpdated=09:59:43}, Item{id=66, name='Lazz', price=5.15, active=false, dateAdded=2019-09-15, timeAdded=09:34:14, dateUpdated=2019-12-14, timeUpdated=14:46:28}, Item{id=62, name='Innojam', price=5.11, active=true, dateAdded=2019-06-27, timeAdded=07:49:14, dateUpdated=2020-03-22, timeUpdated=19:07:13}, Item{id=61, name='Feednation', price=5.02, active=false, dateAdded=2019-08-10, timeAdded=15:35:36, dateUpdated=2019-12-29, timeUpdated=11:19:43}, Item{id=26, name='Brightdog', price=5.01, active=false, dateAdded=2019-04-18, timeAdded=14:46:58, dateUpdated=2019-05-08, timeUpdated=19:28:48}, Item{id=19, name='Yombu', price=4.99, active=true, dateAdded=2019-04-17, timeAdded=15:59:21, dateUpdated=2019-12-17, timeUpdated=10:58:58}, Item{id=2, name='Yacero', price=4.96, active=true, dateAdded=2019-06-23, timeAdded=19:23:34, dateUpdated=2019-07-16, timeUpdated=18:54:58}, Item{id=53, name='Meedoo', price=4.96, active=false, dateAdded=2019-04-15, timeAdded=08:15:47, dateUpdated=2019-10-15, timeUpdated=13:09:41}, Item{id=34, name='Skippad', price=4.72, active=false, dateAdded=2019-10-17, timeAdded=19:20:50, dateUpdated=2020-01-19, timeUpdated=16:23:51}, Item{id=35, name='Gabtype', price=4.62, active=true, dateAdded=2019-09-19, timeAdded=17:10:46, dateUpdated=2020-03-11, timeUpdated=14:20:24}, Item{id=27, name='Voolia', price=4.57, active=true, dateAdded=2019-11-30, timeAdded=17:22:28, dateUpdated=2019-07-28, timeUpdated=14:57:05}, Item{id=73, name='Photobean', price=4.32, active=true, dateAdded=2019-12-18, timeAdded=08:04:49, dateUpdated=2020-02-21, timeUpdated=07:35:24}, Item{id=86, name='Cogidoo', price=4.3, active=false, dateAdded=2019-05-02, timeAdded=17:07:03, dateUpdated=2020-01-18, timeUpdated=08:30:51}, Item{id=87, name='Feedfish', price=4.22, active=true, dateAdded=2019-04-29, timeAdded=12:38, dateUpdated=2019-04-28, timeUpdated=18:52:30}, Item{id=70, name='Wordware', price=3.79, active=false, dateAdded=2020-02-05, timeAdded=09:35:38, dateUpdated=2019-05-31, timeUpdated=10:40:44}, Item{id=58, name='Voomm', price=3.68, active=true, dateAdded=2019-11-30, timeAdded=09:15:11, dateUpdated=2019-06-13, timeUpdated=12:32:21}, Item{id=12, name='Jayo', price=3.6, active=true, dateAdded=2019-04-23, timeAdded=13:56:05, dateUpdated=2019-05-22, timeUpdated=15:53:27}, Item{id=9, name='Flashspan', price=3.35, active=false, dateAdded=2019-08-05, timeAdded=08:52:11, dateUpdated=2019-09-23, timeUpdated=11:23:06}, Item{id=67, name='Shuffletag', price=3.19, active=false, dateAdded=2019-07-10, timeAdded=12:56:46, dateUpdated=2020-03-08, timeUpdated=14:54:53}, Item{id=99, name='Oyonder', price=3.16, active=false, dateAdded=2019-06-23, timeAdded=10:22:10, dateUpdated=2019-10-27, timeUpdated=16:29:22}, Item{id=44, name='Devpulse', price=3.13, active=false, dateAdded=2019-04-30, timeAdded=08:50:53, dateUpdated=2019-09-07, timeUpdated=11:30:27}, Item{id=29, name='Tagcat', price=3.04, active=false, dateAdded=2019-11-27, timeAdded=10:32:58, dateUpdated=2019-08-03, timeUpdated=19:18:25}, Item{id=64, name='Cogilith', price=2.85, active=true, dateAdded=2019-06-27, timeAdded=17:13:52, dateUpdated=2019-11-10, timeUpdated=16:02:38}, Item{id=22, name='Janyx', price=2.75, active=true, dateAdded=2019-07-11, timeAdded=09:46:10, dateUpdated=2019-07-20, timeUpdated=14:33:46}, Item{id=42, name='Innotype', price=2.65, active=false, dateAdded=2019-10-31, timeAdded=12:59:37, dateUpdated=2019-04-03, timeUpdated=13:35:48}, Item{id=83, name='Devbug', price=2.61, active=false, dateAdded=2019-07-30, timeAdded=11:53:14, dateUpdated=2019-11-27, timeUpdated=16:26:09}, Item{id=71, name='Roomm', price=2.55, active=true, dateAdded=2020-03-06, timeAdded=11:52:27, dateUpdated=2019-12-21, timeUpdated=14:03:02}, Item{id=98, name='Yodoo', price=2.31, active=true, dateAdded=2019-06-27, timeAdded=08:03:24, dateUpdated=2019-06-09, timeUpdated=14:18:08}, Item{id=91, name='Jabbercube', price=2.14, active=true, dateAdded=2020-02-11, timeAdded=09:57:15, dateUpdated=2019-12-04, timeUpdated=09:16:24}, Item{id=79, name='Wikido', price=2.09, active=false, dateAdded=2020-02-25, timeAdded=14:45:38, dateUpdated=2020-01-22, timeUpdated=08:48:34}, Item{id=31, name='InnoZ', price=2.08, active=true, dateAdded=2019-07-24, timeAdded=12:26:20, dateUpdated=2020-02-18, timeUpdated=08:35:09}, Item{id=72, name='Yata', price=2.01, active=true, dateAdded=2019-04-29, timeAdded=11:36:15, dateUpdated=2019-10-19, timeUpdated=07:41:40}, Item{id=100, name='Ntags', price=2.0, active=true, dateAdded=2019-07-14, timeAdded=09:29:16, dateUpdated=2019-08-28, timeUpdated=15:51:46}, Item{id=74, name='Oodoo', price=1.84, active=true, dateAdded=2020-02-29, timeAdded=18:47:42, dateUpdated=2019-11-08, timeUpdated=19:20:05}, Item{id=92, name='Rhycero', price=1.61, active=false, dateAdded=2019-09-09, timeAdded=17:51:40, dateUpdated=2019-12-07, timeUpdated=17:39:33}, Item{id=54, name='Eamia', price=1.55, active=true, dateAdded=2020-03-08, timeAdded=17:43:12, dateUpdated=2019-06-09, timeUpdated=14:17:54}, Item{id=20, name='Kaymbo', price=1.37, active=false, dateAdded=2020-01-07, timeAdded=18:04:55, dateUpdated=2019-10-04, timeUpdated=07:35:41}, Item{id=16, name='Eamia', price=1.1, active=false, dateAdded=2020-02-12, timeAdded=10:44:28, dateUpdated=2019-12-21, timeUpdated=13:20:13}, Item{id=1, name='Twitterbeat', price=1.0, active=true, dateAdded=2020-03-21, timeAdded=10:28:56, dateUpdated=2019-04-28, timeUpdated=08:13:54}, Item{id=60, name='Mybuzz', price=0.96, active=true, dateAdded=2019-05-07, timeAdded=09:04:22, dateUpdated=2020-02-14, timeUpdated=19:29:57}, Item{id=69, name='Kwideo', price=0.96, active=false, dateAdded=2020-02-14, timeAdded=14:41:42, dateUpdated=2019-09-29, timeUpdated=10:54:02}, Item{id=33, name='Twinte', price=0.83, active=true, dateAdded=2019-05-28, timeAdded=18:16:31, dateUpdated=2019-04-19, timeUpdated=17:22:29}, Item{id=8, name='Cogilith', price=0.69, active=true, dateAdded=2019-06-22, timeAdded=11:16:06, dateUpdated=2019-10-07, timeUpdated=14:48:39}, Item{id=78, name='Tagopia', price=0.68, active=true, dateAdded=2019-10-22, timeAdded=14:04:32, dateUpdated=2019-11-27, timeUpdated=09:24:31}, Item{id=10, name='Skippad', price=0.31, active=true, dateAdded=2019-10-06, timeAdded=10:50:30, dateUpdated=2019-11-13, timeUpdated=07:42:19}, Item{id=65, name='Browsecat', price=0.18, active=false, dateAdded=2020-03-24, timeAdded=16:35:34, dateUpdated=2020-02-13, timeUpdated=17:43:13}, Item{id=37, name='Ntag', price=0.17, active=false, dateAdded=2019-10-21, timeAdded=13:31:41, dateUpdated=2019-12-03, timeUpdated=13:30:29}, Item{id=52, name='Gigazoom', price=0.11, active=true, dateAdded=2019-05-01, timeAdded=19:20:55, dateUpdated=2019-11-08, timeUpdated=16:28:52}, Item{id=90, name='Devify', price=0.08, active=false, dateAdded=2019-10-05, timeAdded=13:19:29, dateUpdated=2019-09-30, timeUpdated=17:37:15}, Item{id=80, name='Lajo', price=0.05, active=false, dateAdded=2019-09-04, timeAdded=16:26:19, dateUpdated=2019-10-07, timeUpdated=16:48:07}, Item{id=55, name='Vitz', price=0.03, active=true, dateAdded=2020-02-10, timeAdded=17:42:27, dateUpdated=2019-06-21, timeUpdated=16:09:46}]
//
//
//        items.sort((item, t1) -> Double.compare(t1.getPrice(),item.getPrice()));
//
//        return items;
//    }



}
