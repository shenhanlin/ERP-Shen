/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import user.dao.UserDAO;
import user.dao.UserLevelDAO;
import user.model.User;
import user.model.UserLevel;

/**
 *
 * @author hanlinshen
 */
public class LoginService {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserLevelDAO userLevelDAO;
    @Autowired
    private User user;
    @Autowired
    private UserLevel userLevel;

    public String userLoginCheck(String userName, String userPassword) {
        if (userDAO.getUser(userName) != null) {
            user = userDAO.getUser(userName);
            if (user.getUserPassword().equals(userPassword)) {
                 userLevel = userLevelDAO.getUserLevel(user.getUserLevel());
                return userLevel.getUserLevelNmae();
            }
        }
        return null;
    }
}
