package junit.testing.ch1.p41;

/**
 * 테스트 스위트의 품질을 결정하는데 어떤 커버리지 지표도 의존할수는없다.
 *
 * 1. 테스트 대상 시스템의 모든 가능한 결과를 검증한다고 보장할수없다.
 * 2. 외부 라이브러리의 코드 경로를 고려할수있는 커버리지 지표는 없다.
 *
 * 1번 사례
 */
public class StringSizeChecker {

    private static boolean WasLastStringLong;

    public static boolean IsStringLong(String input){
        boolean result = input.length() > 5;
        WasLastStringLong = result;
        return result;
    }

    public static boolean IsStringLong1(String input){
        return input.length() > 5;
    }

    public static boolean isWasLastStringLong() {
        return WasLastStringLong;
    }

}
