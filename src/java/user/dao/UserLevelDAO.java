/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import java.util.List;
import user.model.UserLevel;

/**
 *
 * @author hanlinshen
 */
public interface UserLevelDAO {

    public void insert(UserLevel userLevel);
    public void delete(int userLevelId);
    public void update(UserLevel userLevel);
    public UserLevel getUserLevel(int userLevelId);
    public List<UserLevel> getAllUserLevel();
}
