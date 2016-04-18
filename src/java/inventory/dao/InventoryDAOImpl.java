/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.dao;

import inventory.model.Inventory;
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
public class InventoryDAOImpl implements InventoryDAO {

    private JdbcTemplate jdbcTemplate;

    public InventoryDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Inventory inventory) {
        String sql = "INSERT INTO Inventory (InventoryId,InventoryItemDetailId,InventoryQuantity)"
                + " VALUES (?,?,?)";

        jdbcTemplate.update(sql, inventory.getInventoryId(), inventory.getInventoryItemDetailId(), inventory.getInventoryQuantity());
    }

    @Override
    public void delete(int inventoryId) {
        String sql = "DELETE FROM Inventory WHERE InventoryId=?";
        jdbcTemplate.update(sql, inventoryId);
    }

    @Override
    public void update(Inventory inventory) {
        String sql = "UPDATE Inventory SET InventoryItemDetailId = ?,inventoryQuantity = ? WHERE inventoryId=?";

        jdbcTemplate.update(sql, inventory.getInventoryItemDetailId(), inventory.getInventoryQuantity(), inventory.getInventoryId());
    }

    @Override
    public List<Inventory> getAllInventory() {
        List<Inventory> inventoryList = new ArrayList<>();

        String sql = "SELECT * FROM Inventory";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<Inventory>>() {

            @Override
            public List<Inventory> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {

                    Inventory inventory = new Inventory();
                    inventory.setInventoryId(rs.getInt("InventoryId"));
                    inventory.setInventoryItemDetailId(rs.getInt("InventoryItemDetailId"));
                    inventory.setInventoryQuantity(rs.getInt("InventoryQuantity"));

                    inventoryList.add(inventory);
                }

                return inventoryList;
            }

        });
    }

    @Override
    public List<Inventory> getAllInventoryWithName() {
        List<Inventory> inventoryList = new ArrayList<>();

        String sql = "SELECT Inventory.InventoryId, InventoryItemDetail.InventoryName, Inventory.InventoryQuantity "
                + "FROM Inventory "
                + "INNER JOIN InventoryItemDetail "
                + "ON Inventory.InventoryItemDetailId=InventoryItemDetail.InventoryItemDetailId;";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<Inventory>>() {

            @Override
            public List<Inventory> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {

                    Inventory inventory = new Inventory();
                    inventory.setInventoryId(rs.getInt("InventoryId"));
                    inventory.setInventoryItemDetailName(rs.getString("InventoryName"));
                    inventory.setInventoryQuantity(rs.getInt("InventoryQuantity"));

                    inventoryList.add(inventory);
                }

                return inventoryList;
            }

        });
    }

    @Override
    public Inventory getInventory(int inventoryId) {
        String sql = "SELECT * FROM Inventory WHERE InventoryId=\"" + inventoryId + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Inventory>() {

            @Override
            public Inventory extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Inventory inventory = new Inventory();
                    inventory.setInventoryId(rs.getInt("InventoryId"));
                    inventory.setInventoryItemDetailId(rs.getInt("InventoryItemDetailId"));
                    inventory.setInventoryQuantity(rs.getInt("InventoryQuantity"));
                    return inventory;
                }

                return null;
            }

        });
    }

    @Override
    public Inventory getInventoryByInventoryItemDetailId(int inventoryItemDetailId) {
        String sql = "SELECT * FROM Inventory WHERE InventoryItemDetailId=\"" + inventoryItemDetailId + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Inventory>() {

            @Override
            public Inventory extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Inventory inventory = new Inventory();
                    inventory.setInventoryId(rs.getInt("InventoryId"));
                    inventory.setInventoryItemDetailId(rs.getInt("InventoryItemDetailId"));
                    inventory.setInventoryQuantity(rs.getInt("InventoryQuantity"));
                    return inventory;
                }

                return null;
            }

        });
    }
}
