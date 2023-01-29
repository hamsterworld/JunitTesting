package junit.testing.ch7.finalstep.advanced;

import org.springframework.stereotype.Component;

@Component
public class MessageBus {

    public String sendEmailChangedMessage(int userId,String newEmail){
        return "ok";
    }

}
