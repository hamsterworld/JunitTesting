package junit.testing.ch7.finalstep.advanced.domain_event;

public class DomainEvent {
    private int userId;
    private String NewEmail;

    public DomainEvent(int userId, String newEmail) {
        this.userId = userId;
        NewEmail = newEmail;
    }

    public String getNewEmail() {
        return NewEmail;
    }

    public int getUserId() {
        return userId;
    }
}
