package junit.testing.ch5.p158.GoodApls;

public class UserController {

    public void RenameUser(int userId,String newName){
        User user = GetUserFromDataBase(userId);
        user.setName("햄스터2");
        saveUserToDatabase(user);
    }

    private void saveUserToDatabase(User user) {
        System.out.println(user.getName()+ "을 저장하였습니다.");
    }

    private User GetUserFromDataBase(int userId) {
        return new User("햄스터");
    }

}
