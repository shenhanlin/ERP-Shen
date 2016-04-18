/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.LoginService;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;
import user.model.User;

/**
 *
 * @author hanlinshen
 */
@Controller
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String greetingSubmit(@RequestParam("username") String userName, @RequestParam("userPassword") String userpassword, Model model) {
        
       if(loginService.userLoginCheck(userName, userpassword) != null){
           model.addAttribute("userName", userName);
           model.addAttribute("userLevel", loginService.userLoginCheck(userName, userpassword));
           return "mainPage";
       }
           model.addAttribute("loginResult", "Invalid login information");
        return "index";
    }

}
