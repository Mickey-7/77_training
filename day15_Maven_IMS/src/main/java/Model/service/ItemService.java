package Model.service;

import Model.dao.ItemDAO;
import Model.domain.Item;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//calls ItemDAO - will be called by ItemController
public class ItemService {
    //creating ItemDAO object
    private ItemDAO itemDAO;

//    //invoking the created object inside a constructor
//    public ItemService(ItemDAO itemDAO){
//        this.itemDAO = itemDAO;
//    }
//    //if use the constructor above, it will just give error below:
//    //Error:(18, 30) java: constructor ItemController in class Controller.ItemController cannot be applied to given types;
//    //  required: Model.service.ItemService
//    //  found: no arguments
//    //  reason: actual and formal argument lists differ in length
//    //and will not validate at all as there is a difference in parameter of constructor
//    //declared object constructor on Main have no parameter

    public ItemService() throws SQLException {
        //blank constructor invoking ItemDAO
        itemDAO = new ItemDAO();
    }

    public void addItem(Item item) throws SQLException {
        //invoking itemDAO and throwing exception
        itemDAO.addItem(item);
    }

    public List<Item> viewItemById(Long id) throws SQLException {
        //invoking itemDAO and throwing exception
        return itemDAO.viewItemByID(id);
    }

    public void removeItem(Long id) throws SQLException {
        //invoking itemDAO and throwing exception
        itemDAO.removeItem(id);
    }

    public List<Item> viewItemByName(String name) throws SQLException {
        //invoking itemDAO and throwing exception
        return itemDAO.viewItemByName(name);
    }

    public Map<String,Double> getPriceSummary() throws SQLException {
        return itemDAO.getPriceSummary();
    }


}
