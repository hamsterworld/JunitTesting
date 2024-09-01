package junit.testing.ch8;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    public String ChangeEmail(int userId,String newEmail){
        return userService.changeEmail(userId,newEmail);
    }


}
