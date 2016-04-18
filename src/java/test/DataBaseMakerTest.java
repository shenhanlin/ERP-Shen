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
public class DataBaseMakerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DriverManagerDataSource dataSource;
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dataSource = (DriverManagerDataSource) context.getBean("dataSource");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql;

        sql = "CREATE TABLE UserLevel("
                + "UserLevelId INT NOT NULL AUTO_INCREMENT,"
                + "UserLevelName VARCHAR(45) NOT NULL UNIQUE,"
                + "PRIMARY KEY (UserLevelId));";
        jdbcTemplate.update(sql);

        sql = "CREATE TABLE User("
                + "UserId int NOT NULL AUTO_INCREMENT,"
                + "UserName varchar(45) NOT NULL UNIQUE,"
                + "UserPassword varchar(45) NOT NULL,"
                + "UserLevel INT NOT NULL,"
                + "PRIMARY KEY (UserId),"
                + "CONSTRAINT UserLevel FOREIGN KEY (UserLevel)"
                + "REFERENCES UserLevel(UserLevelId));";
        jdbcTemplate.update(sql);

        sql = "CREATE TABLE UserInformation("
                + "UserInformationId INT NOT NULL AUTO_INCREMENT,"
                + "UserId INT UNIQUE NOT NULL,"
                + "LastName varchar(45) NOT NULL,"
                + "FirstName varchar(45) NOT NULL,"
                + "sex varchar(10),"
                + "age int,"
                + "dateOfBirth Date,"
                + "salary int,"
                + "dateEmployed Date,"
                + "PRIMARY KEY (UserInformationId),"
                + "CONSTRAINT UserId FOREIGN KEY (UserId)"
                + "REFERENCES User(UserId));";
        jdbcTemplate.update(sql);

        sql = "CREATE TABLE EmployeeSchedule("
                + "EmployeeScheduleId INT NOT NULL AUTO_INCREMENT,"
                + "EmployeeId INT NOT NULL,"
                + "Year int NOT NULL,"
                + "Month int NOT NULL,"
                + "scheduledDate varchar(255) NOT NULL,"
                + "PRIMARY KEY (EmployeeScheduleId),"
                + "CONSTRAINT EmployeeId FOREIGN KEY (EmployeeId)"
                + "REFERENCES User(UserId));";
        jdbcTemplate.update(sql);

        sql = "CREATE TABLE InventoryItemDetail("
                + "InventoryItemDetailId INT NOT NULL AUTO_INCREMENT,"
                + "InventoryName varchar(45) UNIQUE NOT NULL,"
                + "individualValue int NOT NULL,"
                + "storageTimeLimit int NOT NULL,"
                + "inventoryImage varchar(45),"
                + "PRIMARY KEY (InventoryItemDetailId));";
        jdbcTemplate.update(sql);

        sql = "CREATE TABLE Inventory("
                + "InventoryId INT NOT NULL AUTO_INCREMENT,"
                + "InventoryItemDetailId INT NOT NULL,"
                + "InventoryQuantity int NOT NULL,"
                + "PRIMARY KEY (InventoryId),"
                + "CONSTRAINT InventoryItemDetailId FOREIGN KEY (InventoryItemDetailId)"
                + "REFERENCES InventoryItemDetail(InventoryItemDetailId));";
        jdbcTemplate.update(sql);

        sql = "CREATE TABLE TransactionHistory("
                + "TransactionId INT NOT NULL AUTO_INCREMENT,"
                + "InventoryId INT NOT NULL,"
                + "TransactionType VARCHAR(10) NOT NULL,"
                + "TransactionQuantity int NOT NULL,"
                + "QuantityBeforeTransaction int NOT NULL,"
                + "QuantityAfterTransaction int NOT NULL,"
                + "TransactionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "Edited int NOT NULL,"
                + "Owner varchar(45) NOT NULL,"
                + "PRIMARY KEY (TransactionId),"
                + "CONSTRAINT InventoryId FOREIGN KEY (InventoryId)"
                + "REFERENCES Inventory(InventoryId));";
        jdbcTemplate.update(sql);

        sql = "CREATE TABLE EditeHistory("
                + "EditeHistoryId int NOT NULL AUTO_INCREMENT,"
                + "EditedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "TransactionId int NOT NULL,"
                + "Owner varchar(45) NOT NULL,"
                + "EditeReason varchar(255) NOT NULL,"
                + "PRIMARY KEY (EditeHistoryId));";
        jdbcTemplate.update(sql);

    }

}
