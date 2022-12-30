package junit.testing.ch1.p39;

import junit.testing.ch1.p37.StringSizeChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSizeCheckerTest {


    // 분기 커버리지에서는 분기가 2번있다.
    // String 의 사이즈가 5보다 크냐? 또는 작냐?
    // 분기커버리지 1/2
    @Test
    void isStringLong() {
        boolean result = StringSizeChecker.IsStringLong("abc");
        Assertions.assertFalse(result);
    }

    // 분기커버리지 1/2
    @Test
    void isStringLong1() {
        boolean result = StringSizeChecker.IsStringLong("abc");
        Assertions.assertFalse(result);
    }
}