/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.dao;

import inventory.model.EditeHistory;
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
public class EditeHistoryDAOImpl implements EditeHistoryDAO {

    private JdbcTemplate jdbcTemplate;

    public EditeHistoryDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(EditeHistory editeHistory) {
        String sql = "INSERT INTO EditeHistory (EditeHistoryId,TransactionId,Owner,EditeReason)"
                + " VALUES (?,?,?,?)";

        jdbcTemplate.update(sql, editeHistory.getEditeHistoryId(), editeHistory.getTransactionId(), editeHistory.getOwner(),editeHistory.getEditeReason());
    }

    @Override
    public void delete(int editeHistoryId) {
        String sql = "DELETE FROM EditeHistory WHERE EditeHistoryId=?";
        jdbcTemplate.update(sql, editeHistoryId);
    }

    @Override
    public void update(EditeHistory editeHistory) {
        String sql = "UPDATE EditeHistory SET TransactionId = ?,Owner = ?,EditeReason = ? WHERE editeHistoryId=?";
        jdbcTemplate.update(sql, editeHistory.getTransactionId(), editeHistory.getOwner(),editeHistory.getEditeReason(),editeHistory.getEditeHistoryId());
    }

    @Override
    public EditeHistory getEditeHistory(int editeHistoryId) {
        String sql = "SELECT * FROM EditeHistory WHERE EditeHistoryId=\"" + editeHistoryId + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<EditeHistory>() {

            @Override
            public EditeHistory extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    EditeHistory editeHistory = new EditeHistory();
                    editeHistory.setEditeHistoryId(rs.getInt("EditeHistoryId"));
                    editeHistory.setTransactionId(rs.getInt("TransactionId"));
                    editeHistory.setEditedDate(rs.getTimestamp("EditedDate"));
                    editeHistory.setOwner(rs.getString("Owner"));
                    editeHistory.setEditeReason(rs.getString("EditeReason"));
                    return editeHistory;
                }

                return null;
            }

        });
    }

    @Override
    public List<EditeHistory> getEditeHistoryByTransactionId(int transactionId) {
        List<EditeHistory> editeHistoryList = new ArrayList<>();

        String sql = "SELECT * FROM EditeHistory WHERE TransactionId=\"" + transactionId + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<EditeHistory>>() {

            @Override
            public List<EditeHistory> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {

                    EditeHistory editeHistory = new EditeHistory();
                    editeHistory.setEditeHistoryId(rs.getInt("EditeHistoryId"));
                    editeHistory.setTransactionId(rs.getInt("TransactionId"));
                    editeHistory.setEditedDate(rs.getTimestamp("EditedDate"));
                    editeHistory.setOwner(rs.getString("Owner"));
                    editeHistory.setEditeReason(rs.getString("EditeReason"));
                    editeHistoryList.add(editeHistory);
                }

                return editeHistoryList;
            }

        });
    }

    @Override
    public List<EditeHistory> getEditeHistoryByOwner(String owner) {
        List<EditeHistory> editeHistoryList = new ArrayList<>();

        String sql = "SELECT * FROM EditeHistory WHERE Owner=\"" + owner + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<EditeHistory>>() {

            @Override
            public List<EditeHistory> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {

                    EditeHistory editeHistory = new EditeHistory();
                    editeHistory.setEditeHistoryId(rs.getInt("EditeHistoryId"));
                    editeHistory.setTransactionId(rs.getInt("TransactionId"));
                    editeHistory.setEditedDate(rs.getTimestamp("EditedDate"));
                    editeHistory.setOwner(rs.getString("Owner"));
                    editeHistory.setEditeReason(rs.getString("EditeReason"));
                    editeHistoryList.add(editeHistory);
                }

                return editeHistoryList;
            }

        });
    }

}
