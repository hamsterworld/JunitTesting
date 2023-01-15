package junit.testing.ch7.twostep;

import junit.testing.ch7.onestep.Repository.DataBase;

public class User {

    public int UserId;
    public String Email;
    public UserType userType;


    public int getUserId() {
        return UserId;
    }

    public String getEmail() {
        return Email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void ChangeEmail(String newEmail,Company company){

        if(Email.equals(newEmail)){
            return;
        }

        UserType newType = company.IsEmailCorporate(newEmail) ? UserType.Customer : UserType.Employee;

        if(userType != newType){
            Integer delta = newType == User.UserType.Employee ? 1:-1;
            company.ChangeNumberOfEmployees(delta);
        }

        this.Email = newEmail;
        this.userType = newType;

    }

    public enum UserType{
        Customer(1),Employee(2);

        private int Number;

        UserType(int number) {
            Number = number;
        }
    }
}
