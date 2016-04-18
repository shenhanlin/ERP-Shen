/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import user.dao.UserInformationDAO;
import user.dao.UserInformationDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.dao.EmployeeScheduleDAO;
import user.dao.EmployeeScheduleDAOImpl;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;
import user.dao.UserLevelDAO;
import user.dao.UserLevelDAOImpl;
import user.model.EmployeeSchedule;
import user.model.User;
import user.model.UserInformation;
import user.model.UserLevel;

/**
 *
 * @author hanlinshen
 */
public class AddingDataToDataBaseTest {

    private static UserLevelDAO userLevelDAO;
    private static UserDAO userDAO;
    private static UserInformationDAO userInformationDAO;
    private static EmployeeScheduleDAO employeeScheduleDAO;
    private static InventoryDAO inventoryDAO;
    private static InventoryItemDetailDAO inventoryItemDetailDAO;
    private static TransactionHistoryDAO transactionHistoryDAO;
    private static EditeHistoryDAO editeHistoryDAO;
    private static UserLevel userLevel;
    private static User user;
    private static UserInformation userInformation;
    private static EmployeeSchedule employeeSchedule;
    private static InventoryItemDetail inventoryItemDetail;
    private static Inventory inventory;
    private static TransactionHistory transactionHistory;
    private static EditeHistory editeHistory;

    public static void main(String[] args) {
        DriverManagerDataSource dataSource;
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dataSource = (DriverManagerDataSource) context.getBean("dataSource");

        userLevelDAO = new UserLevelDAOImpl(dataSource);
        userLevel = createUserLevel("Admin");
        userLevelDAO.insert(userLevel);
        userLevel = createUserLevel("worker");
        userLevelDAO.insert(userLevel);

        userDAO = new UserDAOImpl(dataSource);
        user = createUser("admin", "1234", 1);
        userDAO.insert(user);
        user = createUser("admin1", "2345", 1);
        userDAO.insert(user);
        user = createUser("admin2", "3456", 1);
        userDAO.insert(user);
        user = createUser("admin3", "4567", 2);
        userDAO.insert(user);
        user = createUser("admin4", "5678", 2);
        userDAO.insert(user);

        userInformationDAO = new UserInformationDAOImpl(dataSource);
        user = userDAO.getUser("admin4");
        userInformation = createUserInformation(user.getUserId(), "shen", "hanlin", "M", 24, 2999, "1999-22-22", "2015-22-22");
        userInformationDAO.insert(userInformation);
        user = userDAO.getUser("admin3");
        userInformation = createUserInformation(user.getUserId(), "li", "mei", "F", 25, 2000, "1966-11-11", "2015-01-30");
        userInformationDAO.insert(userInformation);
        user = userDAO.getUser("admin2");
        userInformation = createUserInformation(user.getUserId(), "wang", "lei", "M", 26, 4000, "1678-05-22", "2014-7-22");
        userInformationDAO.insert(userInformation);
        user = userDAO.getUser("admin1");
        userInformation = createUserInformation(user.getUserId(), "xiao", "hua", "F", 21, 3000, "1942-11-22", "2013-06-22");
        userInformationDAO.insert(userInformation);
        user = userDAO.getUser("admin");
        userInformation = createUserInformation(user.getUserId(), "da", "Li", "M", 23, 2300, "1977-06-01", "2013-05-14");
        userInformationDAO.insert(userInformation);

        employeeScheduleDAO = new EmployeeScheduleDAOImpl(dataSource);
        user = userDAO.getUser("admin4");
        employeeSchedule = createEmployeeSchedule(user.getUserId(), 2015, 04, "1,2,3,4,5,6,7");
        employeeScheduleDAO.insert(employeeSchedule);
        user = userDAO.getUser("admin3");
        employeeSchedule = createEmployeeSchedule(user.getUserId(), 2015, 04, "1,2,3,4,5,6,7");
        employeeScheduleDAO.insert(employeeSchedule);
        user = userDAO.getUser("admin2");
        employeeSchedule = createEmployeeSchedule(user.getUserId(), 2015, 05, "1,2,3,4,5,6,7");
        employeeScheduleDAO.insert(employeeSchedule);
        user = userDAO.getUser("admin1");
        employeeSchedule = createEmployeeSchedule(user.getUserId(), 2015, 06, "1,2,3,4,5,6,7");
        employeeScheduleDAO.insert(employeeSchedule);
        user = userDAO.getUser("admin4");
        employeeSchedule = createEmployeeSchedule(user.getUserId(), 2015, 07, "1,2,3,4,5,6,7");
        employeeScheduleDAO.insert(employeeSchedule);

        inventoryItemDetailDAO = new InventoryItemDetailDAOImpl(dataSource);
        inventoryItemDetail = createInventoryItemDetail("Crab", 70, 15, "crab.jpg");
        inventoryItemDetailDAO.insert(inventoryItemDetail);
        inventoryItemDetail = createInventoryItemDetail("Cucumber", 20, 10, "Cucumber.jpg");
        inventoryItemDetailDAO.insert(inventoryItemDetail);
        inventoryItemDetail = createInventoryItemDetail("Cauliflower", 10, 15, "Cauliflower.jpg");
        inventoryItemDetailDAO.insert(inventoryItemDetail);
        inventoryItemDetail = createInventoryItemDetail("Onion", 30, 15, "Onion.jpg");
        inventoryItemDetailDAO.insert(inventoryItemDetail);
        inventoryItemDetail = createInventoryItemDetail("Fish", 70, 10, "Fish.jpg");
        inventoryItemDetailDAO.insert(inventoryItemDetail);

        inventoryDAO = new InventoryDAOImpl(dataSource);
        inventoryItemDetail = inventoryItemDetailDAO.getInventoryDetail("Fish");
        inventory = createInventory(inventoryItemDetail.getInventoryItemDetailId(), 20);
        inventoryDAO.insert(inventory);
        inventoryItemDetail = inventoryItemDetailDAO.getInventoryDetail("Cauliflower");
        inventory = createInventory(inventoryItemDetail.getInventoryItemDetailId(), 40);
        inventoryDAO.insert(inventory);
        inventoryItemDetail = inventoryItemDetailDAO.getInventoryDetail("Cucumber");
        inventory = createInventory(inventoryItemDetail.getInventoryItemDetailId(), 6);
        inventoryDAO.insert(inventory);
        inventoryItemDetail = inventoryItemDetailDAO.getInventoryDetail("Crab");
        inventory = createInventory(inventoryItemDetail.getInventoryItemDetailId(), 15);
        inventoryDAO.insert(inventory);
        inventoryItemDetail = inventoryItemDetailDAO.getInventoryDetail("Onion");
        inventory = createInventory(inventoryItemDetail.getInventoryItemDetailId(), 33);
        inventoryDAO.insert(inventory);

        transactionHistoryDAO = new TransactionHistoryDAOImpl(dataSource);
        inventory = inventoryDAO.getInventoryByInventoryItemDetailId(1);
        transactionHistory = createTransactionHistory(inventory.getInventoryId(), "+", 20, inventory.getInventoryQuantity(), (inventory.getInventoryQuantity() + 20), 0, "shen");
        transactionHistoryDAO.insert(transactionHistory);
        inventory = inventoryDAO.getInventoryByInventoryItemDetailId(2);
        transactionHistory = createTransactionHistory(inventory.getInventoryId(), "-", 10, inventory.getInventoryQuantity(), (inventory.getInventoryQuantity() - 10), 0, "Li");
        transactionHistoryDAO.insert(transactionHistory);
        inventory = inventoryDAO.getInventoryByInventoryItemDetailId(5);
        transactionHistory = createTransactionHistory(inventory.getInventoryId(), "-", 9, inventory.getInventoryQuantity(), (inventory.getInventoryQuantity() - 9), 0, "hua");
        transactionHistoryDAO.insert(transactionHistory);
        inventory = inventoryDAO.getInventoryByInventoryItemDetailId(3);
        transactionHistory = createTransactionHistory(inventory.getInventoryId(), "-", 44, inventory.getInventoryQuantity(), (inventory.getInventoryQuantity() - 44), 0, "fen");
        transactionHistoryDAO.insert(transactionHistory);
        inventory = inventoryDAO.getInventoryByInventoryItemDetailId(4);
        transactionHistory = createTransactionHistory(inventory.getInventoryId(), "+", 55, inventory.getInventoryQuantity(), (inventory.getInventoryQuantity() + 55), 0, "lei");
        transactionHistoryDAO.insert(transactionHistory);

        editeHistoryDAO = new EditeHistoryDAOImpl(dataSource);
        editeHistory = createEditeHistory(1, "Li", "type error");
        editeHistoryDAO.insert(editeHistory);
        editeHistory = createEditeHistory(2, "Wang", "type error");
        editeHistoryDAO.insert(editeHistory);
        editeHistory = createEditeHistory(1, "Shen", "type error");
        editeHistoryDAO.insert(editeHistory);
        editeHistory = createEditeHistory(3, "Lei", "type error");
        editeHistoryDAO.insert(editeHistory);
        editeHistory = createEditeHistory(4, "Xiao", "type error");
        editeHistoryDAO.insert(editeHistory);
    }

    public static UserLevel createUserLevel(String userLevelName) {

        UserLevel userLevel = new UserLevel();
        userLevel.setUserLevelNmae(userLevelName);
        return userLevel;
    }

    public static User createUser(String userName, String userPassword, int userLevel) {

        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserLevel(userLevel);
        return user;
    }

    public static EmployeeSchedule createEmployeeSchedule(int employeeId, int year, int month, String scheduleDate) {

        EmployeeSchedule employeeSchedule = new EmployeeSchedule();
        employeeSchedule.setEmployeeId(employeeId);
        employeeSchedule.setYear(year);
        employeeSchedule.setMonth(month);
        employeeSchedule.setScheduledDate(scheduleDate);
        return employeeSchedule;
    }

    public static UserInformation createUserInformation(int userId, String lastName, String firstName, String sex, int age, int salary, String dateOfBirth, String dateEmployed) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date dateOfBirthx = null;
        Date dateEmployedx = null;
        try {
            dateOfBirthx = format.parse(dateOfBirth);
            dateEmployedx = format.parse(dateEmployed);
        } catch (ParseException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        UserInformation userInformation = new UserInformation();

        userInformation.setUserId(userId);
        userInformation.setLastName(lastName);
        userInformation.setFirstName(firstName);
        userInformation.setSex(sex);
        userInformation.setAge(age);
        userInformation.setSalary(salary);
        userInformation.setDateOfBirth(dateOfBirthx);
        userInformation.setDateEmployed(dateEmployedx);

        return userInformation;
    }

    public static InventoryItemDetail createInventoryItemDetail(String inventoryName, int individualValue, int storageTimeLimit, String inventoryImage) {

        InventoryItemDetail inventoryItemDetail = new InventoryItemDetail();
        inventoryItemDetail.setInventoryName(inventoryName);
        inventoryItemDetail.setIndividualValue(individualValue);
        inventoryItemDetail.setStorageTimeLimit(storageTimeLimit);
        inventoryItemDetail.setInventoryImage(inventoryImage);
        return inventoryItemDetail;
    }

    public static Inventory createInventory(int InventoryItemDetailId, int inventoryQuantity) {

        Inventory inventory = new Inventory();
        inventory.setInventoryItemDetailId(InventoryItemDetailId);
        inventory.setInventoryQuantity(inventoryQuantity);
        return inventory;
    }

    public static TransactionHistory createTransactionHistory(int inventoryId, String transactiontype, int transactionQuantity, int quantityBeforeTransaction, int quantityAfterTransaction, int edited, String owner) {

        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setInventoryId(inventoryId);
        transactionHistory.setTransactionType(transactiontype);
        transactionHistory.setTransactionQuantity(transactionQuantity);
        transactionHistory.setQuantityBeforeTransaction(quantityBeforeTransaction);
        transactionHistory.setQuantityAfterTransaction(quantityAfterTransaction);
        transactionHistory.setEdited(edited);
        transactionHistory.setOwner(owner);
        return transactionHistory;
    }

    public static EditeHistory createEditeHistory(int transactionId, String owner, String editeReason) {

        EditeHistory editeHistory = new EditeHistory();
        editeHistory.setTransactionId(transactionId);
        editeHistory.setOwner(owner);
        editeHistory.setEditeReason(editeReason);
        return editeHistory;
    }
}
