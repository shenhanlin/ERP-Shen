/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.model;

import java.sql.Timestamp;

/**
 *
 * @author hanlinshen
 */
public class EditeHistory {
    private int editeHistoryId;
    private Timestamp editedDate;
    private int transactionId;
    private String owner;
    private String editeReason;

    public int getEditeHistoryId() {
        return editeHistoryId;
    }

    public void setEditeHistoryId(int editeHistoryId) {
        this.editeHistoryId = editeHistoryId;
    }

    public Timestamp getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Timestamp editedDate) {
        this.editedDate = editedDate;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEditeReason() {
        return editeReason;
    }

    public void setEditeReason(String editeReason) {
        this.editeReason = editeReason;
    }
    
    
    
}
