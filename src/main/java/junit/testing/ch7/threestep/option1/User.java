package junit.testing.ch7.threestep.option1;

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

    public String ChangeEmail(String newEmail, Company company){

        // 유저가 이메일을 확인햇는지 안했는지 전제조건을 확인하는 곳
        if(IsEmailConfirmed){
            return "이메일을 변경할수없습니다.";
        }

        if(Email.equals(newEmail)){
            return "같은 이메일은 안됩니다.";
        }

        UserType newType = company.IsEmailCorporate(newEmail) ? UserType.Customer : UserType.Employee;

        if(userType != newType){
            Integer delta = newType == UserType.Employee ? 1:-1;
            company.ChangeNumberOfEmployees(delta);
        }

        this.Email = newEmail;
        this.userType = newType;

        return "성공적으로 변경";
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
