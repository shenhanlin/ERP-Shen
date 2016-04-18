/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import java.util.List;
import user.model.EmployeeSchedule;

/**
 *
 * @author hanlinshen
 */
public interface EmployeeScheduleDAO {

    public void insert(EmployeeSchedule employeeSchedule);
    public void delete(int employeeScheduleId);
    public void update(EmployeeSchedule employeeSchedule);
    public EmployeeSchedule getEmployeeSchedule(int userId,int year , int month);
    public List<EmployeeSchedule> getEmployeeSchedules(int userId);
}
