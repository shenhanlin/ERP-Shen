/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import inventory.dao.InventoryDAO;
import inventory.model.Inventory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import user.dao.UserInformationDAO;
import user.model.UserInformation;

/**
 *
 * @author hanlinshen
 */
@Controller
public class RedirectController {

    @Autowired
    private UserInformationDAO userInformationDAO;
    @Autowired
    private InventoryDAO inventoryDAO;

    @RequestMapping(value = "")
    public String index() {
        return "redirect:ERP-Shen/redirect.jsp";
    }

    @RequestMapping(value = "test")
    public String test() {
        return "mainPage";
    }

    @RequestMapping(value = "employeeManage")
    public String toEmployeeManagePage(Model model) {
        List<UserInformation> employeeList;
        employeeList = userInformationDAO.getAllUserInformation();
        model.addAttribute("employeeList", employeeList);
        return "employeeManage";
    }

    @RequestMapping(value = "inventoryManage")
    public String toInventoryManagePage(Model model) {
        // List<UserInformation> employeeList;
        //employeeList = userInformationDAO.getAllUserInformation();
        //model.addAttribute("employeeList", employeeList);
        List<Inventory> inventoryList;
        inventoryList = inventoryDAO.getAllInventoryWithName();
        model.addAttribute("inventoryList", inventoryList);
        return "inventoryManage";
    }

}
