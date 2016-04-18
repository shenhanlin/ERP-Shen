package test;

import inventory.dao.EditeHistoryDAO;
import inventory.dao.EditeHistoryDAOImpl;
import inventory.dao.InventoryDAO;
import inventory.dao.InventoryDAOImpl;
import inventory.dao.InventoryItemDetailDAO;
import inventory.dao.InventoryItemDetailDAOImpl;
import inventory.dao.TransactionHistoryDAO;
import inventory.dao.TransactionHistoryDAOImpl;
import inventory.model.EditeHistory;
import inventory.model.Inventory;
import inventory.model.InventoryItemDetail;
import inventory.model.TransactionHistory;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.dao.EmployeeScheduleDAO;
import user.dao.EmployeeScheduleDAOImpl;
import user.dao.UserDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import user.dao.UserDAO;
import user.dao.UserInformationDAO;
import user.model.EmployeeSchedule;
import user.model.UserInformation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hanlinshen
 */
public class NewMain {

    private static UserDAO userDAO;
    private static UserInformationDAO userInformationDAO;
    private static EmployeeScheduleDAO employeeScheduleDAO;
    private static InventoryDAO inventoryDAO;
    private static InventoryItemDetailDAO inventoryItemDetailDAO;
    private static TransactionHistoryDAO transactionHistoryDAO;
    private static EditeHistoryDAO editeHistoryDAO;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DriverManagerDataSource dataSource;
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dataSource = (DriverManagerDataSource) context.getBean("dataSource");

        userDAO = new UserDAOImpl(dataSource);
        employeeScheduleDAO = new EmployeeScheduleDAOImpl(dataSource);
        inventoryDAO = new InventoryDAOImpl(dataSource);
        inventoryItemDetailDAO = new InventoryItemDetailDAOImpl(dataSource);
        transactionHistoryDAO = new TransactionHistoryDAOImpl(dataSource);
        editeHistoryDAO = new EditeHistoryDAOImpl(dataSource);

        List<Inventory> inventoryList;
        inventoryList = inventoryDAO.getAllInventoryWithName();
        for (int i = 0; i < inventoryList.size(); i++) {
            System.out.println(inventoryList.get(i).getInventoryId()
                    + " " +inventoryList.get(i).getInventoryItemDetailName()
                            +" "+inventoryList.get(i).getInventoryQuantity());
        }

    }

    public static void printUserInformation(UserInformation userInformation) {
        System.out.println(userInformation.getUserId() + " " + userInformation.getFirstName() + " " + userInformation.getLastName() + " " + userInformation.getSex() + " " + userInformation.getAge() + " " + userInformation.getDateOfBirth() + " " + userInformation.getSalary() + " " + userInformation.getDateEmployed());
    }

    public static void printInventory(Inventory inventory) {
        System.out.println(inventory.getInventoryId() + " " + inventory.getInventoryItemDetailId() + " " + inventory.getInventoryQuantity());
    }

    public static void printInventoryItemDetail(InventoryItemDetail inventoryItemDetail) {
        System.out.println(inventoryItemDetail.getInventoryItemDetailId() + " " + inventoryItemDetail.getInventoryName() + " " + inventoryItemDetail.getIndividualValue() + " " + inventoryItemDetail.getStorageTimeLimit() + " " + inventoryItemDetail.getInventoryImage());
    }

    public static void printTransactionHistory(TransactionHistory transactionHistory) {
        Timestamp timestamp = transactionHistory.getTransactionDate();
        Date date = null;
        if (timestamp != null) {
            date = new Date(timestamp.getTime());
        }

        System.out.println(transactionHistory.getTransactionId() + " " + transactionHistory.getInventoryId() + " " + transactionHistory.getTransactionQuantity() + " " + transactionHistory.getTransactionDate() + " " + transactionHistory.getEdited() + " " + transactionHistory.getOwner());
    }

    public static void printEditeHistory(EditeHistory editeHistory) {
        System.out.println(editeHistory.getEditeHistoryId() + " " + editeHistory.getTransactionId() + " " + editeHistory.getEditedDate() + " " + editeHistory.getOwner() + "  " + editeHistory.getEditeReason());
    }
}
