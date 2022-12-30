package junit.testing.ch1.p37;

/**
 * 코드 커버리지, 테스트 커버리지는 부정지표이다. 긍정지표로써는 사용될수없다.
 *
 * 테스트 커버리지 = (제품 코드 라인 수)/(전체 라인 수)
 *
 * 테스트 커버리지로 숫자장난을 쉽게 할수있다.
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
