package junit.testing.ch7.threestep;

import junit.testing.ch7.onestep.RequestMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping
    public String changeEmail(int userId,String newEmail){
        return userService.ChangeEmail(userId, newEmail);
    }
}
