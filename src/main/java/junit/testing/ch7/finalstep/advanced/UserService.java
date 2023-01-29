package junit.testing.ch7.finalstep.advanced;

import junit.testing.ch7.finalstep.advanced.domain_event.DomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 변경되지않는 경우에도 메시지를 보내야되는경우라면?
 *
 */
@Service
@RequiredArgsConstructor
public class UserService {

    public static final List<DomainEvent> domainEvents = new ArrayList<>();
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

        // 이런 도메인이벤트 class 의 도입으로 비즈니스 로직 파편화와 의존성주입같은 테스트를 힘들게하는것들을 단번에 쳐낼수있었다.
        for (DomainEvent domainEvent : domainEvents) {
            messageBus.sendEmailChangedMessage(domainEvent.getUserId(), domainEvent.getNewEmail());
        }

        return "ok";

    }

    private static String Preconditons(String checked){
        if(checked == null){
            return "cant change";
        }
        return null;
    }
}
