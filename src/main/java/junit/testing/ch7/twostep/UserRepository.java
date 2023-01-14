package junit.testing.ch7.twostep;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static junit.testing.ch7.twostep.User.UserType.Customer;
import static junit.testing.ch7.twostep.User.UserType.Employee;


@Repository
public class UserRepository {
    static List<User> data = new ArrayList<>();

    static{
        User user1 = new User();
        user1.setUserId(1);
        user1.setEmail("ssoboro1@gmail.com");
        user1.setUserType(Employee);

        User user2 = new User();
        user2.setUserId(2);
        user2.setEmail("ssoboro2@gmail.com");
        user2.setUserType(Employee);

        User user3 = new User();
        user3.setUserId(3);
        user3.setEmail("ssoboro3@gmail.com");
        user3.setUserType(Employee);

        User user4 = new User();
        user4.setUserId(4);
        user4.setEmail("ssoboro4@gmail.com");
        user4.setUserType(Customer);

        User user5 = new User();
        user5.setUserId(5);
        user5.setEmail("ssoboro5@gmail.com");
        user5.setUserType(Customer);

        User user6 = new User();
        user6.setUserId(6);
        user6.setEmail("ssoboro6@gmail.com");
        user6.setUserType(Customer);

        data.add(user1);
        data.add(user2);
        data.add(user3);
        data.add(user4);
        data.add(user5);
        data.add(user6);
    }

    public User findUserById(int userId){
        for (User datum : data) {
            if (datum.UserId == userId){
                return datum;
            }
        }
        return null;
    }

    public Object[] getCompany(){
        return new Object[2];
    }

    public void saveCompany(Integer newNumber) {

    }

    public void saveUser(User user) {

    }
}
