package junit.testing.ch1.p39;

/**
 * 분기커버리지는 테스트커버리지의 이러한 단점을 극복하는데 도움이 된다.
 *
 * 분기 커버리지 = (통과분기) / (전체분기수)
 */
public class StringSizeChecker {

    public static boolean IsStringLong(String input){
        if(input.length() > 5){
            return true;
        }
        return false;
    }

    public static boolean IsStringLong1(String input){
        return input.length() > 5;
    }

}
