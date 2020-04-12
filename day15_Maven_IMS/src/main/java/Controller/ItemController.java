package Controller;

import Model.domain.Item;
import Model.service.ItemService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//will be called by Main
public class ItemController {
    //creating ItemService object
    private ItemService itemService;

//    //invoking itemService in a constructor
//    public ItemController(ItemService itemService){
//        this.itemService = itemService;
//    }
//    //if use the constructor above, it will just give error below:
//    //Error:(18, 30) java: constructor ItemController in class Controller.ItemController cannot be applied to given types;
//    //  required: Model.service.ItemService
//    //  found: no arguments
//    //  reason: actual and formal argument lists differ in length
//    //and will not validate at all as there is a difference in parameter of constructor
//    //declared object constructor on Main have no parameter

    public ItemController() throws SQLException {
        //blank constructor invoking ItemService
        itemService = new ItemService();
    }

    public void addItem(Item item) throws SQLException {
        itemService.addItem(item);
    }

    public List<Item> viewItemById(Long id) throws SQLException {
        return itemService.viewItemById(id);
    }

    public void removeItem(Long id) throws SQLException {
        itemService.removeItem(id);
    }

    public List<Item> viewItemByName(String name) throws SQLException {
        return itemService.viewItemByName(name);
    }

    public Map<String,Double> getPriceSummary() throws SQLException {
        return itemService.getPriceSummary();
    }
}

