package user.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import user.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hanlinshen
 */
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO User (userId,userName,userPassword,userLevel)"
                + " VALUES (?,?,?,?)";

        jdbcTemplate.update(sql, user.getUserId(), user.getUserName(), user.getUserPassword(), user.getUserLevel());
    }

    @Override
    public void delete(int userId) {
        String sql = "DELETE FROM User WHERE userId=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE User SET userName = ?,userPassword = ?,userLevel = ? WHERE userId=?";

        jdbcTemplate.update(sql, user.getUserName(), user.getUserPassword(), user.getUserLevel(), user.getUserId());
    }

    @Override
    public User getUser(int userId) {
        String sql = "SELECT * FROM User WHERE userId=" + userId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    User user = new User();
                    user.setUserId(rs.getInt("userId"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserPassword(rs.getString("userPassword"));
                    user.setUserLevel(rs.getInt("userLevel"));
                    return user;
                }

                return null;
            }

        });
    }

    @Override
    public User getUser(String userName) {
        String sql = "SELECT * FROM User WHERE UserName=\"" + userName + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    User user = new User();
                    user.setUserId(rs.getInt("userId"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserPassword(rs.getString("userPassword"));
                    user.setUserLevel(rs.getInt("userLevel"));
                    return user;
                }

                return null;
            }

        });
    }

    @Override
    public List<User> getUserByLevel(String userLevel) {
        List<User> userList = new ArrayList<>();

        String sql = "SELECT * FROM User WHERE UserLevel=\"" + userLevel + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<User>>() {

            @Override
            public List<User> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {
                    User user = new User();
                    user.setUserId(rs.getInt("userId"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserPassword(rs.getString("userPassword"));
                    user.setUserLevel(rs.getInt("userLevel"));
                    userList.add(user);
                }
                return userList;
            }

        });
    }

}
