package junit.testing.ch3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 전형적인 안티패턴 단위테스트의 예시
 *
 * 테스트간 결합도를 높이지 말것.
 */
class CustomerTest {

    private static Store store;
    private static Customer customer;

    @BeforeAll
    static void before(){
        store = new NYStore();
        customer = new Customer();
        store.AddInventory(Product.Shampoo,15);
    }

    @Test
    void purchase1() {
        boolean success = customer.Purchase(store, Product.Shampoo, 10);
        Assertions.assertTrue(success);
        Assertions.assertEquals(5,store.getCount());
    }

    @Test
    void purchase2() {
        boolean success = customer.Purchase(store, Product.Shampoo, 10);
        Assertions.assertFalse(success);
    }
}