package junit.testing.ch1.p42;

/**
 * 테스트 스위트의 품질을 결정하는데 어떤 커버리지 지표도 의존할수는없다.
 *
 * 1. 테스트 대상 시스템의 모든 가능한 결과를 검증한다고 보장할수없다.
 * 2. 외부 라이브러리의 코드 경로를 고려할수있는 커버리지 지표는 없다.
 *
 * 2번 사례
 * 외부 라이브러리가 통과하는 코드경로를 고려하지않는다.
 */
public class StringSizeChecker {


    public static int Parse(String input){
        return Integer.parseInt(input);
    }


}
