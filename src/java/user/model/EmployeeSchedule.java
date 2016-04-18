/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.model;

/**
 *
 * @author hanlinshen
 */
public class EmployeeSchedule {
    private int employeeScheduleId;
    private int employeeId;
    private int year;
    private int month;
    private String scheduledDate;

    public int getEmployeeScheduleId() {
        return employeeScheduleId;
    }

    public void setEmployeeScheduleId(int employeeScheduleId) {
        this.employeeScheduleId = employeeScheduleId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

}
