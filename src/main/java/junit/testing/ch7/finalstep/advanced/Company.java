package junit.testing.ch7.finalstep.advanced;

public class Company {

    public String DomainName;
    public int NumberOfEmployees;

    public String getDomainName() {
        return DomainName;
    }

    public void setDomainName(String domainName) {
        DomainName = domainName;
    }

    public int getNumberOfEmployees() {
        return NumberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        NumberOfEmployees = numberOfEmployees;
    }

    public void ChangeNumberOfEmployees(int delta){
        if(NumberOfEmployees+delta <= 0){
            throw new IllegalArgumentException("회사인원은 1명보다 적어질수없습니다.");
        }
        NumberOfEmployees += delta;
    }

    public boolean IsEmailCorporate(String newEmail){
        String emailDomain = newEmail.split("@")[1];
        return emailDomain.equals(DomainName);
    }
}
