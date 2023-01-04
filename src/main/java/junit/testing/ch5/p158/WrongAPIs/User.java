package junit.testing.ch5.p158.WrongAPIs;

// 캡슐화가 잘안됫다.
// normal 호출되는 시점에 따라 get()의 결과가 달라질수있긴함.
public class User {
    public String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String NormalizeName(String name){
        String result = name.trim();
        if(result.length() > 50){
            return result.substring(0,50);
        }
        return result;
    }

}
