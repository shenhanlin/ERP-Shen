/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.dao;

import inventory.model.Inventory;
import java.util.List;

/**
 *
 * @author hanlinshen
 */
public interface InventoryDAO {

    public void insert(Inventory inventory);
    public void delete(int inventoryId);
    public void update(Inventory inventory);
    public List<Inventory> getAllInventory();
    public List<Inventory> getAllInventoryWithName();
    public Inventory getInventory(int inventoryId);
    public Inventory getInventoryByInventoryItemDetailId(int inventoryItemDetailId);
}
