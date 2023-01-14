package junit.testing.ch6.outputbasedtesting.functional;

/**
 * DataBase 에 무엇을 저장하거나 내부컬렉션에 저장하거나 하지않는다. 그저 출력만 할뿐이다.
 * 이런 출력기반 단위테스트 스타일은 함수형이라고한다.
 * 이런것들은 사이드이펙트가 없다.
 * 그래서 함수형 프로그래밍을 선호한다.
 */
public class PriceEngine {

    // 고른상품마다 1%추가하고 최대할인율은 20%로 제한한다
    public float CalculateDiscount(Product[] products){
        float discount = products.length * 0.01f;
        return Math.min(discount,0.2f);
    }


}
