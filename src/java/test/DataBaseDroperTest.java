/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author hanlinshen
 */
public class DataBaseDroperTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DriverManagerDataSource dataSource;
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dataSource = (DriverManagerDataSource) context.getBean("dataSource");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql;

        sql = "DROP TABLE UserInformation";
        jdbcTemplate.update(sql);

        sql = "DROP TABLE EmployeeSchedule";
        jdbcTemplate.update(sql);

        sql = "DROP TABLE User";
        jdbcTemplate.update(sql);

        sql = "DROP TABLE UserLevel";
        jdbcTemplate.update(sql);

        sql = "DROP TABLE EditeHistory";
        jdbcTemplate.update(sql);

        sql = "DROP TABLE TransactionHistory";
        jdbcTemplate.update(sql);

        sql = "DROP TABLE Inventory";
        jdbcTemplate.update(sql);

        sql = "DROP TABLE InventoryItemDetail";
        jdbcTemplate.update(sql);

    }

}
