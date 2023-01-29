package junit.testing.ch7.threestep;

import junit.testing.ch7.threestep.option1.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 지금 로직은 만약에 사용자가 이메일을 확인상태가아니라면
 * 이메일을 변경할수없다는 전제조건이 확인되야한다.
 * 그러나 String s = user.ChangeEmail(newEmail, company);
 * 에서 확인하므로 바꿀수있는상황이든 아니든 무조건 쿼리해 오기때문에 성능저하가 일어난다.
 * 무조건 company 를 외부의존성으로 연결해서 데이터를 가져와야한다.
 * 이는 컨트롤러의 복잡성을 포기한 대가로 성능이 저하가 된 케이스이다.
 *
 * option1의 user 를 사용했다.
 *
 * 어쨋든 도메인에서 핵심매서드에서 확인해야될게많아지니
 * 도메인로직이 복잡해질수도있다.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    // 암시적 의존성을 명시적으로 만들어버리기.
    private final UserRepository userRepository;
    private final MessageBus messageBus;

    public String ChangeEmail(int userId,String newEmail){

        User foundedUser = userRepository.findUserById(userId);
        User user = UserFactory.createUser(foundedUser);

        Object[] companyData = userRepository.getCompany();
        Company company = CompanyFactory.createCompany(companyData);

        // 내가 의사결정한다.
        String s = user.ChangeEmail(newEmail, company);

        if(!s.equals("error")){
            return "error";
        }

        userRepository.saveUser(user);
        return messageBus.sendEmailChangedMessage(userId,newEmail);

    }

}
