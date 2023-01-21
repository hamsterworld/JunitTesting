package junit.testing.ch7.threestep;

import junit.testing.ch7.threestep.option1.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    // 암시적 의존성을 명시적으로 만들어버리기.
    private final UserRepository userRepository;
    private final MessageBus messageBus;

    // 첫번째, 캡슐화가 잘 된것인가?
    public String ChangeEmail(int userId,String newEmail){

        User foundedUser = userRepository.findUserById(userId);
        User user = UserFactory.createUser(foundedUser);

        Object[] companyData = userRepository.getCompany();
        Company company = CompanyFactory.createCompany(companyData);

        // 내가 의사결정한다.
        user.ChangeEmail(newEmail,company);

        userRepository.saveUser(user);
        return messageBus.sendEmailChangedMessage(userId,newEmail);

    }

}
