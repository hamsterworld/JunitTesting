package junit.testing.ch6.outputbasedtesting.functional;

import junit.testing.ch6.outputbasedtesting.functional.PriceEngine;
import junit.testing.ch6.outputbasedtesting.functional.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceEngineTest {

    @Test
    void Discount_of_two_products(){
        Product[] products = new Product[2];
        products[0] = new Product("샴푸",10000);
        products[1] = new Product("책",5000);
        PriceEngine sut = new PriceEngine();

        float discount = sut.CalculateDiscount(products);

        assertEquals(0.02,discount);
    }

}