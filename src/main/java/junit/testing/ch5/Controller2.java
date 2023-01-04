package junit.testing.ch5;

public class Controller2 {

    private final IDatabase iDatabase;

    public Controller2(IDatabase iDatabase) {
        this.iDatabase = iDatabase;
    }

    public Report CreateReport(){
        int 10 = iDatabase.GetNumberOfUsers();
        return new Report();
    }

}
