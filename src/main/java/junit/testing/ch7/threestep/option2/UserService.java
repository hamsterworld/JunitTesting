package junit.testing.ch7.threestep.option2;

import junit.testing.ch7.threestep.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 성능저하를 원치않으므로
 * 컨트롤러단이 복잡해지더라도
 * 성능과 도메인 분리를 둘다 생각햇다.
 * 하지만 user 에서 어쨋든 새로운 매서드를 파서 확인하므로 (이부분에서조차 컨트롤러단에서는 의사결정을 하지않고 오직, 도메인클래스만이 의사결정을 한다. ex) user.CanChangeEmail())
 */
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
