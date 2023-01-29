package junit.testing.ch7.finalstep;

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

        // 여기서 팅겨낸다 할지라도 어쨋든 필드값은 Email 과 userType 은 들어와있으므로 메시지버스에서 메시지를 보내게된다.
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
