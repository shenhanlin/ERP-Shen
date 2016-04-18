/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.dao;

import inventory.model.InventoryItemDetail;

/**
 *
 * @author hanlinshen
 */
public interface InventoryItemDetailDAO {
    public void insert(InventoryItemDetail inventoryItemDetail);
    public void delete(int inventoryId);
    public void update(InventoryItemDetail inventoryItemDetail);
    public InventoryItemDetail getInventoryDetail(int inventoryId);
    public InventoryItemDetail getInventoryDetail(String inventoryName);
}
