package user.model;

import java.util.Date;

/**
 *
 * @author hanlinshen
 */
public class UserInformation {
    private int UserInformationId;
    private int userId;
    private String lastName;
    private String firstName;
    private String sex;
    private int age;
    private Date dateOfBirth;
    private int salary;
    private Date dateEmployed;

    public int getUserInformationId() {
        return UserInformationId;
    }

    public void setUserInformationId(int UserInformationId) {
        this.UserInformationId = UserInformationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDateEmployed() {
        return dateEmployed;
    }

    public void setDateEmployed(Date dateOfEmployed) {
        this.dateEmployed = dateOfEmployed;
    }

    
    
}
