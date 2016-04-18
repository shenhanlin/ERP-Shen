/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.dao;

import inventory.model.EditeHistory;
import java.util.List;

/**
 *
 * @author hanlinshen
 */
public interface EditeHistoryDAO {

    public void insert(EditeHistory editeHistory);
    public void delete(int editeHistoryId);
    public void update(EditeHistory editeHistory);
    public EditeHistory getEditeHistory(int editeHistoryId);
    public List<EditeHistory> getEditeHistoryByTransactionId(int transactionId);
    public List<EditeHistory> getEditeHistoryByOwner(String owner);
}
