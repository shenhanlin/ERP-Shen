/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.dao;

import inventory.model.InventoryItemDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author hanlinshen
 */
public class InventoryItemDetailDAOImpl implements InventoryItemDetailDAO {

    private JdbcTemplate jdbcTemplate;

    public InventoryItemDetailDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(InventoryItemDetail inventoryItemDetail) {
        String sql = "INSERT INTO InventoryItemDetail (inventoryName,individualValue,storageTimeLimit,inventoryImage)"
                + " VALUES (?,?,?,?)";

        jdbcTemplate.update(sql,inventoryItemDetail.getInventoryName(), inventoryItemDetail.getIndividualValue(), inventoryItemDetail.getStorageTimeLimit(), inventoryItemDetail.getInventoryImage());
    }

    @Override
    public void delete(int InventoryItemDetailId) {
        String sql = "DELETE FROM InventoryItemDetail WHERE InventoryItemDetailId=?";
        jdbcTemplate.update(sql, InventoryItemDetailId);
    }

    @Override
    public void update(InventoryItemDetail inventoryItemDetail) {
        String sql = "UPDATE InventoryItemDetail SET inventoryName = ?,individualValue = ?,storageTimeLimit = ?,inventoryImage = ? WHERE InventoryItemDetailId=?";

        jdbcTemplate.update(sql, inventoryItemDetail.getInventoryName(), inventoryItemDetail.getIndividualValue(), inventoryItemDetail.getStorageTimeLimit(), inventoryItemDetail.getInventoryImage(), inventoryItemDetail.getInventoryItemDetailId());
    }

    @Override
    public InventoryItemDetail getInventoryDetail(int InventoryItemDetailId) {
        String sql = "SELECT * FROM InventoryItemDetail WHERE InventoryItemDetailId=\"" + InventoryItemDetailId + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<InventoryItemDetail>() {

            @Override
            public InventoryItemDetail extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    InventoryItemDetail inventoryItemDetail = new InventoryItemDetail();
                    inventoryItemDetail.setInventoryItemDetailId(rs.getInt("InventoryItemDetailId"));
                    inventoryItemDetail.setInventoryName(rs.getString("InventoryName"));
                    inventoryItemDetail.setIndividualValue(rs.getInt("IndividualValue"));
                    inventoryItemDetail.setStorageTimeLimit(rs.getInt("StorageTimeLimit"));
                    inventoryItemDetail.setInventoryImage(rs.getString("InventoryImage"));
                    return inventoryItemDetail;
                }

                return null;
            }

        });
    }

    @Override
    public InventoryItemDetail getInventoryDetail(String inventoryName) {
        String sql = "SELECT * FROM InventoryItemDetail WHERE InventoryName=\"" + inventoryName + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<InventoryItemDetail>() {

            @Override
            public InventoryItemDetail extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    InventoryItemDetail inventoryItemDetail = new InventoryItemDetail();
                    inventoryItemDetail.setInventoryItemDetailId(rs.getInt("InventoryItemDetailId"));
                    inventoryItemDetail.setInventoryName(rs.getString("InventoryName"));
                    inventoryItemDetail.setIndividualValue(rs.getInt("IndividualValue"));
                    inventoryItemDetail.setStorageTimeLimit(rs.getInt("StorageTimeLimit"));
                    inventoryItemDetail.setInventoryImage(rs.getString("InventoryImage"));
                    return inventoryItemDetail;
                }

                return null;
            }

        });
    }

}
