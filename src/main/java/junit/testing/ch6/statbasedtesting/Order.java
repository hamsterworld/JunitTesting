package junit.testing.ch6.statbasedtesting;

import java.util.ArrayList;
import java.util.List;

/**
 * 작업이 완료된이후 상태를 확인해보는 테스트
 */
public class Order {

    private static List<Product> productList = new ArrayList<>();
    private List<Product> ReadOnlyList;

    public void AddProduct(Product product){
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<Product> getReadOnlyList() {
        return ReadOnlyList;
    }
}
