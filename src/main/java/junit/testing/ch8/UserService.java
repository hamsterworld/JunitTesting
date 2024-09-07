package junit.testing.ch8;


import junit.testing.ch7.finalstep.MessageBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final MessageBus messageBus;

    public String changeEmail(int userId, String newEmail) {
        User user = userRepository.getUserById(userId);

        Preconditons(user.CanChangeEmail());

        Company company = userRepository.getCompany();

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
