/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.model;

/**
 *
 * @author hanlinshen
 */
public class Inventory {
   private int inventoryId;
   private int inventoryItemDetailId;
   private String inventoryItemDetailName;
   private int inventoryQuantity;

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getInventoryItemDetailId() {
        return inventoryItemDetailId;
    }

    public void setInventoryItemDetailId(int inventoryItemDetailId) {
        this.inventoryItemDetailId = inventoryItemDetailId;
    }

    public String getInventoryItemDetailName() {
        return inventoryItemDetailName;
    }

    public void setInventoryItemDetailName(String inventoryItemDetailName) {
        this.inventoryItemDetailName = inventoryItemDetailName;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }
   
   
    
    
}
