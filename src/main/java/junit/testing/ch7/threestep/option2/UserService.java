package junit.testing.ch7.threestep.option2;

import junit.testing.ch7.threestep.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final MessageBus messageBus;

    public String ChangeEmail(int userId,String newEmail){

        User foundedUser = userRepository.findUserById(userId);
        User user = UserFactory.createUser(foundedUser);

        // 컴퍼니는 이메일 확인된이후 확인이 된다.
        // 그러나 이러한방법은 domainModel 의 캡슐화가 부족하게된다.
//        if(user.IsEmailConfirmed){
//            return "cant change a confirmed email ";
//        }

        // 아래 이런식으로 변경한다.
        Preconditons(user.CanChangeEmail());

        Object[] companyData = userRepository.getCompany();
        Company company = CompanyFactory.createCompany(companyData);

        // 내가 의사결정한다.
        user.ChangeEmail(newEmail,company);

        userRepository.saveUser(user);
        return messageBus.sendEmailChangedMessage(userId,newEmail);

    }

    private static String Preconditons(String checked){
        if(checked == null){
            return "cant change";
        }
        return null;
    }
}
