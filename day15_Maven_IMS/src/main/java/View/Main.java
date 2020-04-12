package View;

import Controller.ItemController;
import Model.domain.Item;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    //creating ItemController object
    private static ItemController itemController;
    //hover on ItemController() then surround with try/catch
    static {
        try {
            itemController = new ItemController();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws SQLException {

        //Exercise:
        //* Design an inventory management system
        //Functions:
        //* Add item (item has id, name, original price, active, date added, date updated)
        //* View item
        //    - id, name, original price, date added, date updated
        //    - (Bonus) current value (item’s current value decreases by 10% every year since date added)
        //        + ex: 01/01/2010 - 100, 01/01/2011 - 90, 01/01/2012 - 81
        //- Remove item (set active to false)
        //- Get item stock by item name (return count of active items)
        //- Get item original price summary (show average, highest, lowest)
        //- (Bonus) Get list of obsolete items (list of items with current value lower than 60% of original)
        //- (Bonus) Remove obsolete items
        //Note/s:
        //- Use MVC
        //-----------------------------------------------------------


        System.out.println("what would you like to do?\n" +
                "1) Add Item\n" +
                "2) View Item by Id\n" +
                "3) Remove Item\n" +
                "4) View Item by Name\n" +
                "5) View Price Summary\n" +
                "6) Exit");
        int toDo = scanner.nextInt();

        boolean status = true;
        while (status){
            while (toDo==1){
                System.out.println("1");
                addItem();
                System.out.println("what would you like to do?\n" +
                        "1) Add Item\n" +
                        "2) View Item by Id\n" +
                        "3) Remove Item\n" +
                        "4) View Item by Name\n" +
                        "5) View Price Summary\n" +
                        "6) Exit");
                toDo = scanner.nextInt();
            }
            while (toDo==2){
                System.out.println("2");
                System.out.println(viewItemById());
                System.out.println("what would you like to do?\n" +
                        "1) Add Item\n" +
                        "2) View Item by Id\n" +
                        "3) Remove Item\n" +
                        "4) View Item by Name\n" +
                        "5) View Price Summary\n" +
                        "6) Exit");
                toDo = scanner.nextInt();
            }
            while (toDo==3){
                System.out.println("3");
                removeItem();
                System.out.println("what would you like to do?\n" +
                        "1) Add Item\n" +
                        "2) View Item by Id\n" +
                        "3) Remove Item\n" +
                        "4) View Item by Name\n" +
                        "5) View Price Summary\n" +
                        "6) Exit");
                toDo = scanner.nextInt();
            }
            while (toDo==4){
                System.out.println("4");
                System.out.println(viewItemByName());
                System.out.println("what would you like to do?\n" +
                        "1) Add Item\n" +
                        "2) View Item by Id\n" +
                        "3) Remove Item\n" +
                        "4) View Item by Name\n" +
                        "5) View Price Summary\n" +
                        "6) Exit");
                toDo = scanner.nextInt();
            }
            while (toDo==5){
                System.out.println("5");
                System.out.println(getPriceSummary());
                System.out.println("what would you like to do?\n" +
                        "1) Add Item\n" +
                        "2) View Item by Id\n" +
                        "3) Remove Item\n" +
                        "4) View Item by Name\n" +
                        "5) View Price Summary\n" +
                        "6) Exit");
                toDo = scanner.nextInt();
            }
            while (toDo==6){
                System.out.println("6");
                status=false;
                break;
            }
        }
    }


    private static void addItem() throws SQLException {
        System.out.println("enter item id");
        long id = scanner.nextLong();
        System.out.println("enter item name");
        String name = scanner.next();
        System.out.println("enter item price");
        double price = scanner.nextDouble();
        //creating blank Item object
        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setPrice(price);
        itemController.addItem(item);
    }

    private static List<Item> viewItemById() throws SQLException {
        System.out.println("enter item id : ");
        long id = scanner.nextLong();
        return itemController.viewItemById(id);
    }

    private static void removeItem() throws SQLException {
        System.out.println("enter item id : ");
        long id = scanner.nextInt();
        itemController.removeItem(id);
    }

    private static List<Item> viewItemByName() throws SQLException {
        System.out.println("enter item name : ");
        String name = scanner.next();
         return itemController.viewItemByName(name);
    }

    private static Map<String,Double> getPriceSummary() throws SQLException {
        return itemController.getPriceSummary();
    }
}
