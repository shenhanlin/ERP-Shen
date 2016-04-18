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
import user.model.UserInformation;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author hanlinshen
 */
public class UserInformationDAOImpl implements UserInformationDAO {

    private final JdbcTemplate jdbcTemplate ;

    public UserInformationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(UserInformation userInformation) {
        String sql = "INSERT INTO UserInformation (userId,lastName,firstName,sex,age,dateOfBirth,salary,dateEmployed)"
                + " VALUES (?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, userInformation.getUserId(), userInformation.getLastName(), userInformation.getFirstName(), userInformation.getSex(), userInformation.getAge(), userInformation.getDateOfBirth(), userInformation.getSalary(), userInformation.getDateEmployed());
    }

    @Override
    public void delete(int UserInformationId) {
        String sql = "DELETE FROM UserInformation WHERE UserInformationId=?";
        jdbcTemplate.update(sql, UserInformationId);
    }

    @Override
    public void update(UserInformation userInformation) {
        String sql = "UPDATE UserInformation SET lastName = ?,firstName = ?,sex = ?,age = ?,dateOfBirth = ?,salary = ?,dateEmployed = ? WHERE UserInformationId=?";

        jdbcTemplate.update(sql, userInformation.getLastName(), userInformation.getFirstName(), userInformation.getSex(), userInformation.getAge(), userInformation.getDateOfBirth(), userInformation.getSalary(), userInformation.getDateEmployed(), userInformation.getUserInformationId());
    }

    @Override
    public UserInformation getUserInformation(int userId) {
        String sql = "SELECT * FROM UserInformation WHERE UserID=\"" + userId + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<UserInformation>() {

            @Override
            public UserInformation extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    
                    UserInformation userInformation = new UserInformation();
                    userInformation.setUserInformationId(rs.getInt("UserInformationId"));
                    userInformation.setUserId(rs.getInt("userId"));
                    userInformation.setLastName(rs.getString("LastName"));
                    userInformation.setFirstName(rs.getString("FirstName"));
                    userInformation.setSex(rs.getString("Sex"));
                    userInformation.setAge(rs.getInt("Age"));
                    userInformation.setSalary(rs.getInt("Salary"));
                    userInformation.setDateOfBirth(rs.getDate("DateOfBirth"));
                    userInformation.setDateEmployed(rs.getDate("DateEmployed"));

                    return userInformation;
                }

                return null;
            }

        });
    }

    @Override
    public List<UserInformation> getUserInformation(String lastName) {
        List<UserInformation> userInforamtionList = new ArrayList<>();
                String sql = "SELECT * FROM UserInformation WHERE LastName=\"" + lastName + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<UserInformation>>() {

            @Override
            public List<UserInformation> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {
                    
                    UserInformation userInformation = new UserInformation();
                    userInformation.setUserInformationId(rs.getInt("UserInformationId"));
                    userInformation.setUserId(rs.getInt("userId"));
                    userInformation.setLastName(rs.getString("LastName"));
                    userInformation.setFirstName(rs.getString("FirstName"));
                    userInformation.setSex(rs.getString("Sex"));
                    userInformation.setAge(rs.getInt("Age"));
                    userInformation.setSalary(rs.getInt("Salary"));
                    userInformation.setDateOfBirth(rs.getDate("DateOfBirth"));
                    userInformation.setDateEmployed(rs.getDate("DateEmployed"));

                    userInforamtionList.add(userInformation);
                }

                return userInforamtionList;
            }

        });
    }

    @Override
    public List<UserInformation> getUserInformation(String lastName, String firstName) {
                List<UserInformation> userInforamtionList = new ArrayList<>();
                String sql = "SELECT * FROM UserInformation WHERE LastName=\"" + lastName + "\"" + "AND FirstName =\"" + firstName + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<UserInformation>>() {

            @Override
            public List<UserInformation> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {
                    
                    UserInformation userInformation = new UserInformation();
                    userInformation.setUserInformationId(rs.getInt("UserInformationId"));
                    userInformation.setUserId(rs.getInt("userId"));
                    userInformation.setLastName(rs.getString("LastName"));
                    userInformation.setFirstName(rs.getString("FirstName"));
                    userInformation.setSex(rs.getString("Sex"));
                    userInformation.setAge(rs.getInt("Age"));
                    userInformation.setSalary(rs.getInt("Salary"));
                    userInformation.setDateOfBirth(rs.getDate("DateOfBirth"));
                    userInformation.setDateEmployed(rs.getDate("DateEmployed"));

                    userInforamtionList.add(userInformation);
                }

                return userInforamtionList;
            }

        });
    }

    @Override
    public List<UserInformation> getAllUserInformation() {
                        List<UserInformation> userInforamtionList = new ArrayList<>();
                String sql = "SELECT * FROM UserInformation";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<UserInformation>>() {

            @Override
            public List<UserInformation> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {
                    
                    UserInformation userInformation = new UserInformation();
                    userInformation.setUserInformationId(rs.getInt("UserInformationId"));
                    userInformation.setUserId(rs.getInt("userId"));
                    userInformation.setLastName(rs.getString("LastName"));
                    userInformation.setFirstName(rs.getString("FirstName"));
                    userInformation.setSex(rs.getString("Sex"));
                    userInformation.setAge(rs.getInt("Age"));
                    userInformation.setSalary(rs.getInt("Salary"));
                    userInformation.setDateOfBirth(rs.getDate("DateOfBirth"));
                    userInformation.setDateEmployed(rs.getDate("DateEmployed"));

                    userInforamtionList.add(userInformation);
                }

                return userInforamtionList;
            }

        });
    }

}
