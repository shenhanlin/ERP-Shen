/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.dao;

import inventory.model.TransactionHistory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author hanlinshen
 */
public class TransactionHistoryDAOImpl implements TransactionHistoryDAO {

    private JdbcTemplate jdbcTemplate;

    public TransactionHistoryDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(TransactionHistory transactionHistory) {
        String sql = "INSERT INTO TransactionHistory (InventoryId,TransactionType,TransactionQuantity,QuantityBeforeTransaction,QuantityAfterTransaction,Edited,Owner)"
                + " VALUES (?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, transactionHistory.getInventoryId(), transactionHistory.getTransactionType(), transactionHistory.getTransactionQuantity(), transactionHistory.getQuantityBeforeTransaction(), transactionHistory.getQuantityAfterTransaction(), 0, transactionHistory.getOwner());
    }

    @Override
    public void delete(int transactionId) {
        String sql = "DELETE FROM TransactionHistory WHERE transactionId=?";
        jdbcTemplate.update(sql, transactionId);
    }

    @Override
    public void update(TransactionHistory transactionHistory) {
        String sql = "UPDATE TransactionHistory SET InventoryId = ?,TransactionType = ?,TransactionQuantity = ?,QuantityAfterTransaction = ?,Edited = ?,Owner = ? WHERE TransactionId=?";

        jdbcTemplate.update(sql, transactionHistory.getInventoryId(), transactionHistory.getTransactionType(), transactionHistory.getTransactionQuantity(), transactionHistory.getQuantityAfterTransaction(), 1, transactionHistory.getOwner(), transactionHistory.getTransactionId());
    }

    @Override
    public TransactionHistory getTransactionHistory(int transactionId) {
        String sql = "SELECT * FROM TransactionHistory WHERE TransactionId=\"" + transactionId + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<TransactionHistory>() {

            @Override
            public TransactionHistory extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    TransactionHistory transactionHistory = new TransactionHistory();
                    transactionHistory.setTransactionId(rs.getInt("TransactionId"));
                    transactionHistory.setInventoryId(rs.getInt("InventoryId"));
                    transactionHistory.setTransactionType(rs.getString("TransactionType"));
                    transactionHistory.setTransactionQuantity(rs.getInt("TransactionQuantity"));
                    transactionHistory.setQuantityBeforeTransaction(rs.getInt("QuantityBeforeTransaction"));
                    transactionHistory.setQuantityAfterTransaction(rs.getInt("QuantityAfterTransaction"));
                    transactionHistory.setTransactionDate(rs.getTimestamp("TransactionDate"));
                    transactionHistory.setEdited(rs.getInt("Edited"));
                    transactionHistory.setOwner(rs.getString("Owner"));
                    return transactionHistory;
                }

                return null;
            }

        });
    }

    @Override
    public List<TransactionHistory> getTransactionHistoryByInventory(int inventoryId) {
        List<TransactionHistory> transactionHistoryList = new ArrayList<>();

        String sql = "SELECT * FROM TransactionHistory WHERE InventoryId=\"" + inventoryId + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<TransactionHistory>>() {

            @Override
            public List<TransactionHistory> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {

                    TransactionHistory transactionHistory = new TransactionHistory();
                    transactionHistory.setTransactionId(rs.getInt("TransactionId"));
                    transactionHistory.setInventoryId(rs.getInt("InventoryId"));
                    transactionHistory.setTransactionType(rs.getString("TransactionType"));
                    transactionHistory.setTransactionQuantity(rs.getInt("TransactionQuantity"));
                    transactionHistory.setQuantityBeforeTransaction(rs.getInt("QuantityBeforeTransaction"));
                    transactionHistory.setQuantityAfterTransaction(rs.getInt("QuantityAfterTransaction"));
                    transactionHistory.setTransactionDate(rs.getTimestamp("TransactionDate"));
                    transactionHistory.setEdited(rs.getInt("Edited"));
                    transactionHistory.setOwner(rs.getString("Owner"));

                    transactionHistoryList.add(transactionHistory);
                }

                return transactionHistoryList;
            }

        });
    }

    @Override
    public List<TransactionHistory> getTransactionHistoryByOwner(String owner) {
        List<TransactionHistory> transactionHistoryList = new ArrayList<>();

        String sql = "SELECT * FROM TransactionHistory WHERE Owner=\"" + owner + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<TransactionHistory>>() {

            @Override
            public List<TransactionHistory> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {

                    TransactionHistory transactionHistory = new TransactionHistory();
                    transactionHistory.setTransactionId(rs.getInt("TransactionId"));
                    transactionHistory.setInventoryId(rs.getInt("InventoryId"));
                    transactionHistory.setTransactionType(rs.getString("TransactionType"));
                    transactionHistory.setTransactionQuantity(rs.getInt("TransactionQuantity"));
                    transactionHistory.setQuantityBeforeTransaction(rs.getInt("QuantityBeforeTransaction"));
                    transactionHistory.setQuantityAfterTransaction(rs.getInt("QuantityAfterTransaction"));
                    transactionHistory.setTransactionDate(rs.getTimestamp("TransactionDate"));
                    transactionHistory.setEdited(rs.getInt("Edited"));
                    transactionHistory.setOwner(rs.getString("Owner"));

                    transactionHistoryList.add(transactionHistory);
                }

                return transactionHistoryList;
            }

        });
    }

    @Override
    public List<TransactionHistory> getTransactionHistoryByType(String transactionType) {
        List<TransactionHistory> transactionHistoryList = new ArrayList<>();
        String sql = "SELECT * FROM TransactionHistory WHERE TransactionType=\"" + transactionType + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<TransactionHistory>>() {

            @Override
            public List<TransactionHistory> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {

                    TransactionHistory transactionHistory = new TransactionHistory();
                    transactionHistory.setTransactionId(rs.getInt("TransactionId"));
                    transactionHistory.setInventoryId(rs.getInt("InventoryId"));
                    transactionHistory.setTransactionType(rs.getString("TransactionType"));
                    transactionHistory.setTransactionQuantity(rs.getInt("TransactionQuantity"));
                    transactionHistory.setQuantityBeforeTransaction(rs.getInt("QuantityBeforeTransaction"));
                    transactionHistory.setQuantityAfterTransaction(rs.getInt("QuantityAfterTransaction"));
                    transactionHistory.setTransactionDate(rs.getTimestamp("TransactionDate"));
                    transactionHistory.setEdited(rs.getInt("Edited"));
                    transactionHistory.setOwner(rs.getString("Owner"));

                    transactionHistoryList.add(transactionHistory);
                }

                return transactionHistoryList;
            }

        });
    }

}
