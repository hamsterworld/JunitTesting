package junit.testing.ch5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;

public class Sending_a_greetings_email_Test {

    @Test
    @DisplayName("목도구로 목을 생성")
    void Sending_a_greetings_email1(){

        //준비
        IEmailGateway mock = Mockito.mock(IEmailGateway.class);
        Controller1 sut = new Controller1(mock);

        //테스트
        sut.GreetUser("ssoboro1@gmail.com");

        //검증
        verify(mock,atMostOnce()).SendGreetingsEmail("ssoboro1@gmail.com");
    }

    @Test
    @DisplayName("목도구로 스텁을 생성")
    void Sending_a_greetings_email2(){

        //준비
        IEmailGateway mock = Mockito.mock(IEmailGateway.class);
        Controller1 sut = new Controller1(mock);

        //테스트
        sut.GreetUser("ssoboro1@gmail.com");

        //검증
        verify(mock,atMostOnce()).SendGreetingsEmail("ssoboro1@gmail.com");
    }



}
