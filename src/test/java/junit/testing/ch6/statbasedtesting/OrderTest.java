package junit.testing.ch6.statbasedtesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 출력기반과는 달리 product order 의 내부컬렉션을 확인한다.
 */
class OrderTest {

    @Test
    void Adding_a_product_to_an_order(){
        Product product = new Product("샴푸",20000);
        Order order = new Order();

        order.AddProduct(product);

        Assertions.assertEquals(1,order.getProductList().size());
        Assertions.assertEquals(product,order.getProductList().get(0));
    }

}