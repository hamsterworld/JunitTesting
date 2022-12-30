package junit.testing.ch1.p37;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


class StringSizeCheckerTest {


    // 테스트커버리지는 3/4 = 75% 가된다.
    @Test
    void isStringLongTest() {
        boolean result = StringSizeChecker.IsStringLong("abc");
        assertFalse(result);
    }

    // 테스트커버리지는 1/1 = 100% 가된다.
    @Test
    void isStringLongTest1() {
        boolean result = StringSizeChecker.IsStringLong1("abc");
        assertFalse(result);
    }

}