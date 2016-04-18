/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import java.util.List;
import user.model.UserInformation;

/**
 *
 * @author hanlinshen
 */
public interface UserInformationDAO {
    public void insert(UserInformation userInformation);
    public void delete(int UserInformationId);
    public void update(UserInformation userInformation);
    public UserInformation getUserInformation(int UserId);
    public List<UserInformation> getUserInformation(String lastName);
    public List<UserInformation> getUserInformation(String lastName, String firstName);
    public List<UserInformation> getAllUserInformation();
}
