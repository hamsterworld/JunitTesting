package junit.testing.ch8;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public User getUserById(int userId) {
        // 어쨋든 찾아서 준다.
        return null;
    }

    public Company getCompany() {
        // 어쨋든 찾아서 준다
        return null;
    }

    public void saveUser(User user) {
        // 어쨋든 저장
    }
}
