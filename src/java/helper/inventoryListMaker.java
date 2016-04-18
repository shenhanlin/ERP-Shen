/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import inventory.dao.InventoryDAO;
import inventory.dao.InventoryItemDetailDAO;
import inventory.model.Inventory;
import inventory.model.InventoryItemDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author hanlinshen
 */
public class inventoryListMaker {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private InventoryDAO inventoryDAO;
    @Autowired
    private InventoryItemDetailDAO inventoryItemDetailDAO;
    @Autowired
    private Inventory inventory;
    @Autowired
    private InventoryItemDetail inventoryItemDetail;
    
}
