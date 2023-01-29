package junit.testing.ch7.finalstep;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 변경되지않는 경우에도 메시지를 보내야되는경우라면?
 *
 */
@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final MessageBus messageBus;

    public String ChangeEmail(int userId,String newEmail){

        User foundedUser = userRepository.findUserById(userId);
        User user = UserFactory.createUser(foundedUser);

        Preconditons(user.CanChangeEmail());

        Object[] companyData = userRepository.getCompany();
        Company company = CompanyFactory.createCompany(companyData);

        // 내가 의사결정한다.
        user.ChangeEmail(newEmail,company);

        userRepository.saveUser(user);

        // 아래처럼 업데이트가 안됫을때는 메시지버스를 보내고싶지않다.
        // 물론 아까처럼 컨트롤러단에서 변경됫는지안됫는지 확인하는 전제조건로직을 할수도있지만
        // 비즈니스로직이 파편화되는 경향이 있는것 같다.
        // 너무파편화된다면 도메인로직에 외부의존성을 넘겨서 복잡해지는 상황까지 초래할수도있다.
        // 그래서 도메인이벤트를 사용해보자.
        return messageBus.sendEmailChangedMessage(userId,newEmail);

    }

    private static String Preconditons(String checked){
        if(checked == null){
            return "cant change";
        }
        return null;
    }
}
