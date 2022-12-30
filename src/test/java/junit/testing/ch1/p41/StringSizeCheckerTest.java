package junit.testing.ch1.p41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSizeCheckerTest {

    // 분기 커버리지 50%
    @Test
    void isStringLong() {
        boolean result1 = StringSizeChecker.IsStringLong("abc");    // false 반환
        Assertions.assertFalse(result1);
    }

    // 분기 커버리지 100% --> 재밌는건 분기커버리지 50%든 100%든 필드에 새로운값을 쓰는 로직이 있는데,
    // 이는 검증하지않고 분기커버리지는 둘다 100%,50%를 보여주고있다.
    // 그래서 분기커버러지만 충족했다고해서 모든 코드를 테스트한것을 의미하지않는다.
    @Test
    void isStringLong1() {
        boolean result1 = StringSizeChecker.IsStringLong("abc");    // false 반환
        boolean result2 = StringSizeChecker.IsStringLong("abcded"); // true 반환

        Assertions.assertFalse(result1);
        Assertions.assertTrue(result2);
    }

    // 분기커버리지 100% , 테스트커버리지 100%
    // 그러나 검증이 없다. 전혀 쓸모없는 테스트이다.
    // 검증이 있다한들 분기커버리지와 함께 테스트 스위트 품질을 결정하는데 사용될수없다....
    @Test
    void isWasLastStringLong() {
        boolean result1 = StringSizeChecker.IsStringLong("abc");    // false 반환
        boolean result2 = StringSizeChecker.IsStringLong("abcded"); // true 반환
    }
}