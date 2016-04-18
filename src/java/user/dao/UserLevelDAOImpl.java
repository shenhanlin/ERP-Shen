/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import user.model.UserLevel;

/**
 *
 * @author hanlinshen
 */
public class UserLevelDAOImpl implements UserLevelDAO {

    private JdbcTemplate jdbcTemplate;

    public UserLevelDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(UserLevel userLevel) {
        String sql = "INSERT INTO UserLevel (UserLevelName)"
                + " VALUES (?)";

        jdbcTemplate.update(sql, userLevel.getUserLevelNmae());
    }

    @Override
    public void delete(int userLevelId) {
        String sql = "DELETE FROM UserLevel WHERE UserLevelId=?";
        jdbcTemplate.update(sql, userLevelId);
    }

    @Override
    public void update(UserLevel userLevel) {
        String sql = "UPDATE User SET userLevelName = ? WHERE userLevelId=?";

        jdbcTemplate.update(sql, userLevel.getUserLevelNmae(), userLevel.getUserLevelId());
    }

    @Override
    public UserLevel getUserLevel(int userLevelId) {
        String sql = "SELECT * FROM UserLevel WHERE UserLevelId=" + userLevelId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<UserLevel>() {

            @Override
            public UserLevel extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    UserLevel userLevel = new UserLevel();
                    userLevel.setUserLevelId(rs.getInt("UserLevelId"));
                    userLevel.setUserLevelNmae(rs.getString("UserLevelName"));
                    return userLevel;
                }

                return null;
            }

        });
    }

    @Override
    public List<UserLevel> getAllUserLevel() {
        List<UserLevel> userLevelList = new ArrayList<>();

        String sql = "SELECT * FROM UserLevel";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<UserLevel>>() {

            @Override
            public List<UserLevel> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {
                    UserLevel userLevel = new UserLevel();
                    userLevel.setUserLevelId(rs.getInt("UserLevelId"));
                    userLevel.setUserLevelNmae(rs.getString("UserLevelName"));
                    userLevelList.add(userLevel);
                }
                return userLevelList;
            }

        });
    }

}
