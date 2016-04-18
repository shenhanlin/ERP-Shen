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
import user.model.EmployeeSchedule;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author hanlinshen
 */
public class EmployeeScheduleDAOImpl implements EmployeeScheduleDAO {

    private JdbcTemplate jdbcTemplate;

    public EmployeeScheduleDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(EmployeeSchedule employeeSchedule) {
        if (getEmployeeSchedule(employeeSchedule.getEmployeeId(), employeeSchedule.getYear(), employeeSchedule.getMonth()) == null) {
            String sql = "INSERT INTO EmployeeSchedule (EmployeeId,Year,Month,ScheduledDate)"
                    + " VALUES (?,?,?,?)";
            jdbcTemplate.update(sql, employeeSchedule.getEmployeeId(), employeeSchedule.getYear(), employeeSchedule.getMonth(), employeeSchedule.getScheduledDate());
        } else {
            System.out.println("This employee already had this month's schedule");
        }

    }

    @Override
    public void delete(int employeeScheduleId) {
        String sql = "DELETE FROM EmployeeSchedule WHERE employeeScheduleId=?";
        jdbcTemplate.update(sql, employeeScheduleId);
    }

    @Override
    public void update(EmployeeSchedule employeeSchedule) {
        String sql = "UPDATE EmployeeSchedule SET ScheduledDate = ? WHERE EmployeeId=? AND Year = ? AND Month = ?";
        jdbcTemplate.update(sql, employeeSchedule.getScheduledDate(), employeeSchedule.getEmployeeId(), employeeSchedule.getYear(), employeeSchedule.getMonth());
    }

    @Override
    public EmployeeSchedule getEmployeeSchedule(int employeeId, int year, int month) {
        String sql = "SELECT * FROM EmployeeSchedule WHERE EmployeeId=\"" + employeeId + "\"" + "AND Year =\"" + year + "\"" + "AND Month =\"" + month + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<EmployeeSchedule>() {

            @Override
            public EmployeeSchedule extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    EmployeeSchedule employeeSchedule = new EmployeeSchedule();
                    employeeSchedule.setEmployeeScheduleId(rs.getInt("EmployeeScheduleId"));
                    employeeSchedule.setEmployeeId(rs.getInt("EmployeeId"));
                    employeeSchedule.setYear(rs.getInt("Year"));
                    employeeSchedule.setMonth(rs.getInt("Month"));
                    employeeSchedule.setScheduledDate(rs.getString("ScheduledDate"));
                    return employeeSchedule;
                }

                return null;
            }

        });
    }

    @Override
    public List<EmployeeSchedule> getEmployeeSchedules(int userId) {
        List<EmployeeSchedule> employeeScheduleList = new ArrayList<>();

        String sql = "SELECT * FROM EmployeeSchedule WHERE UserID=\"" + userId + "\"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeSchedule>>() {

            @Override
            public List<EmployeeSchedule> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                while (rs.next()) {

                    EmployeeSchedule employeeSchedule = new EmployeeSchedule();
                    employeeSchedule.setEmployeeScheduleId(rs.getInt("EmployeeScheduleId"));
                    employeeSchedule.setEmployeeId(rs.getInt("EmployeeId"));
                    employeeSchedule.setYear(rs.getInt("Year"));
                    employeeSchedule.setMonth(rs.getInt("Month"));
                    employeeSchedule.setScheduledDate(rs.getString("ScheduledDate"));

                    employeeScheduleList.add(employeeSchedule);
                }

                return employeeScheduleList;
            }

        });
    }

}
