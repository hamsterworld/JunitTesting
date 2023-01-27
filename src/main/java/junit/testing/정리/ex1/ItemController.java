package junit.testing.정리.ex1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    //GetMapping 있다고 가정 , 이 유저의 할인율을 특정 아이템 카테고리에대한 계산하는 로직이라고 생각해보자.
    public String CalculateDiscountRate(String userId,int itemCode){
        return itemService.getItemList(userId,itemCode);
    }

}
