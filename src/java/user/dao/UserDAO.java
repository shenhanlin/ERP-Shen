package user.dao;

import java.util.List;
import user.model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hanlinshen
 */
public interface UserDAO {
    public void insert(User user);
    public void delete(int userId);
    public void update(User user);
    public User getUser(int userId);
    public User getUser(String userName);
    public List<User> getUserByLevel(String userLevel);
}
