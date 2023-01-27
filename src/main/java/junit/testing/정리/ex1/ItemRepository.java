package junit.testing.정리.ex1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {
    public String getUserInfo(String userId) {
        return "자 유저 정보";
    }

    public List<String> getItemList(String startDtm, String endDtm) {
        return new ArrayList<>();
    }

    public void saveDiscountRate(String userId, String discountRate) {
        String test = "저장";
    }
}
