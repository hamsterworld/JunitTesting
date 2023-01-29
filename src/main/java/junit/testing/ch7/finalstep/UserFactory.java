package junit.testing.ch7.finalstep;


import java.util.Objects;

public class UserFactory {
    // 사실책에서는 Object[]로받은 데이터를 instance 로 재구성하는 복잡한 로직이다.
    // 그러나 한번 해봤다.
    public static User createUser(User user){
        validateUser(user);

        User newUser = new User();
        newUser.setUserId(user.getUserId());
        newUser.setEmail(user.getEmail());
        newUser.setUserType(user.getUserType());

        return newUser;
    }

    private static void validateUser(User user){
        Objects.requireNonNull(user);
    }

}
