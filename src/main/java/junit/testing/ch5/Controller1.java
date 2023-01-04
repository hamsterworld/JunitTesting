package junit.testing.ch5;

public class Controller1 {
    private final IEmailGateway iEmailGateway;

    public Controller1(IEmailGateway iEmailGateway) {
        this.iEmailGateway = iEmailGateway;
    }

    public void GreetUser(String s) {
        SendGreetingsEmail(s);
    }

    public void SendGreetingsEmail(String s){
        System.out.println(s);
    }
}
