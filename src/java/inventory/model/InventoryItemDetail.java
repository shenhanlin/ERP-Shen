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
public class InventoryItemDetail {
    private int inventoryItemDetailId;
    private String inventoryName;
    private int individualValue;
    private int storageTimeLimit;
    private String inventoryImage;

    public int getInventoryItemDetailId() {
        return inventoryItemDetailId;
    }

    public void setInventoryItemDetailId(int inventoryItemDetailId) {
        this.inventoryItemDetailId = inventoryItemDetailId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public int getIndividualValue() {
        return individualValue;
    }

    public void setIndividualValue(int individualValue) {
        this.individualValue = individualValue;
    }

    public int getStorageTimeLimit() {
        return storageTimeLimit;
    }

    public void setStorageTimeLimit(int storageTimeLimit) {
        this.storageTimeLimit = storageTimeLimit;
    }

    public String getInventoryImage() {
        return inventoryImage;
    }

    public void setInventoryImage(String inventoryImage) {
        this.inventoryImage = inventoryImage;
    }
    
    
    
}
