package junit.testing.ch8;

import org.springframework.stereotype.Component;

@Component
public class MessageBus {

    public String sendEmailChangedMessage(int userId,String newEmail){
        return "ok";
    }

}
