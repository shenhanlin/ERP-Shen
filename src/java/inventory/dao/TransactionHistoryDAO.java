/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.dao;

import inventory.model.TransactionHistory;
import java.util.List;

/**
 *
 * @author hanlinshen
 */
public interface TransactionHistoryDAO {
    public void insert(TransactionHistory transactionHistory);
    public void delete(int transactionId);
    public void update(TransactionHistory transactionHistory);
    public TransactionHistory getTransactionHistory(int TransactionId);
    public List<TransactionHistory> getTransactionHistoryByInventory(int inventoryId);
    public List<TransactionHistory> getTransactionHistoryByOwner(String owner);
    public List<TransactionHistory> getTransactionHistoryByType(String transactionType);
}
