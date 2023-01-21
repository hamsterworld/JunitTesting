package junit.testing.ch7.threestep.option2;

import junit.testing.ch7.threestep.Company;

public class User {

    public int UserId;
    public String Email;
    public UserType userType;
    //
    public boolean IsEmailConfirmed;

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

    public void ChangeEmail(String newEmail, Company company){

        if(Email.equals(newEmail)){
            return;
        }

        UserType newType = company.IsEmailCorporate(newEmail) ? UserType.Customer : UserType.Employee;

        if(userType != newType){
            Integer delta = newType == UserType.Employee ? 1:-1;
            company.ChangeNumberOfEmployees(delta);
        }

        this.Email = newEmail;
        this.userType = newType;

    }

    public String CanChangeEmail(){
        if(IsEmailConfirmed){
            return "Cant change a confirmed email";
        }
        return null;
    }

    public enum UserType{
        Customer(1),Employee(2);

        private int Number;

        UserType(int number) {
            Number = number;
        }
    }

    public boolean isEmailConfirmed() {
        return IsEmailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        IsEmailConfirmed = emailConfirmed;
    }
}
