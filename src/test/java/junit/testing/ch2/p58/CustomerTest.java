package junit.testing.ch2.p58;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerTest {


    @Test
    @DisplayName("고전 스타일로 작성된 단위 테스트")
    void purchase1(){
        //준비
        Store store = new NYStore();
        store.AddInventory(Product.Shampoo,10);
        Customer customer = new Customer();

        //실행
        boolean success = customer.Purchase(store, Product.Shampoo, 5);

        //검증
        Assertions.assertTrue(success);
        Assertions.assertEquals(5,store.getCount());
    }

    @Test
    @DisplayName("고전 스타일로 작성된 단위 테스트")
    void purchase2(){
        //준비
        Store store = new NYStore();
        store.AddInventory(Product.Shampoo,10);
        Customer customer = new Customer();

        //실행
        boolean success = customer.Purchase(store, Product.Shampoo, 15);

        //검증
        Assertions.assertFalse(success);
        Assertions.assertEquals(10,store.getCount());
    }

    @Test
    @DisplayName("런던 스타일로 작성된 단위 테스트")
    void purchase3() {
        //준비
        Store store = Mockito.mock(Store.class);
        when(store.HasEnoughInventory(Product.Shampoo,5)).thenReturn(true);
        Customer customer = new Customer();

        //실행
        boolean success = customer.Purchase(store, Product.Shampoo, 5);

        //검증
        Assertions.assertTrue(success);
        verify(store,atMostOnce()).RemoveInventory(Product.Shampoo,5);

    }

    @Test
    @DisplayName("런던 스타일로 작성된 단위 테스트")
    void purchase4() {
        //준비
        Store store = Mockito.mock(Store.class);
        when(store.HasEnoughInventory(Product.Shampoo,15)).thenReturn(false);
        Customer customer = new Customer();

        //실행
        boolean success = customer.Purchase(store, Product.Shampoo, 15);

        //검증
        Assertions.assertFalse(success);
        verify(store,never()).RemoveInventory(Product.Shampoo,10);

    }
}