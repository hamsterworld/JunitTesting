package junit.testing.ch5.p158.GoodApls;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    private String NormalizeName(String name){
        String result = name.trim();
        if(result.length() > 50){
            return result.substring(0,50);
        }
        return result;
    }

    public void setName(String name) {
        this.name = NormalizeName(name);
    }
}
