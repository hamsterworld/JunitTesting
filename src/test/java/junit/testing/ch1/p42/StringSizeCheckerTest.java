package junit.testing.ch1.p42;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringSizeCheckerTest {

    // 분기 커버리지100%
    // 그러나 ParseInt 에서
    // null 이들어간다면? ""가 들어간다면? "5" 가들어간다면? "숫자가아닌애들" 이들어간다면?
    // 등등 여러경로가 등장한다. 그래서 수많은 예외상황(edge case)에 빠질수있지만 테스트에서 [모든 예외상황]을 다룰수없다.

    // 커버리지 지표들이 외부 라이브러리의 경로까지 고려해야한다는것을 뜻하지않는다 (고려해서도 안된다.)
    // 즉, 커버리지 지표들로는 좋은 단위테스트인지 아닌지는 검증할수없다는 뜻이다. 긍정지표는 될수없다.
    @Test
    void parse() {
        int parse = StringSizeChecker.Parse("10");
        Assertions.assertEquals(10,parse);
    }
}