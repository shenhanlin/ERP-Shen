/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author hanlinshen
 */
public class TransactionHistory {
    private int transactionId;
    private int inventoryId;
    private String transactionType;
    private int transactionQuantity;
    private int quantityBeforeTransaction;
    private int quantityAfterTransaction;
    private Timestamp transactionDate;
    private int edited;
    private String owner;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(int transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public int getQuantityBeforeTransaction() {
        return quantityBeforeTransaction;
    }

    public void setQuantityBeforeTransaction(int quantityBeforeTransaction) {
        this.quantityBeforeTransaction = quantityBeforeTransaction;
    }

    public int getQuantityAfterTransaction() {
        return quantityAfterTransaction;
    }

    public void setQuantityAfterTransaction(int quantityAfterTransaction) {
        this.quantityAfterTransaction = quantityAfterTransaction;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getEdited() {
        return edited;
    }

    public void setEdited(int edited) {
        this.edited = edited;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    
    
    
}
