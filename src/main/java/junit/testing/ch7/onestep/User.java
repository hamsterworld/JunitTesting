package junit.testing.ch7.onestep;

import junit.testing.ch7.onestep.Repository.DataBase;
import junit.testing.ch7.onestep.socket.MessageBus;
import org.springframework.stereotype.Controller;

@Controller
public class User {

    public int UserId;
    public String Email;
    public UserType userType;

    // 막말로하면 정말 이런식으로 외부와 연계된것.
    // 엄청 애매해졌다. 우측상단에 복잡한코드가 되버림.
    @RequestMapping
    public void ChangeEmail(int userId,String newEmail){

        User userById = DataBase.findUserById(userId);

        this.UserId = userById.getUserId();
        this.Email = userById.getEmail();
        this.userType = userById.getUserType();

        if(this.Email.equals(newEmail)){
            return;
        }

        Object[] company = DataBase.getCompany();

        String companyDomainName = (String) company[0];
        Integer numberOfEmployees = (Integer) company[1];

        String emailDomain = newEmail.split("@")[1];
        boolean isEmailCorporate = emailDomain.equals(companyDomainName);

        UserType newType = isEmailCorporate ? UserType.Customer : UserType.Employee;

        if(userType != newType){
            Integer delta = newType == UserType.Employee ? 1:-1;
            Integer newNumber = numberOfEmployees + delta;
            DataBase.saveCompany(newNumber);
        }

        this.Email = newEmail;
        this.userType = newType;

        DataBase.saveUser(this);
        MessageBus.sendEmailChangedMessage(userId,newEmail);
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }


    public enum UserType{
        Customer(1),Employee(2);

        private int Number;

        UserType(int number) {
            Number = number;
        }
    }
}
