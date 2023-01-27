package junit.testing.정리.ex1;

import junit.testing.정리.ex1.domain.CalculateDiscountRate;
import junit.testing.정리.ex1.domain.checkItemListByUserId;
import junit.testing.정리.ex1.domain.classifyItemByItemCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public String getItemList(String userId,int itemCode) {

        // 유저등급을 보기위해 가져온다.
        String userInfo = itemRepository.getUserInfo(userId); // => 하나의 코드조각단위

        // 최근까지 한달동안 구매한 itemList 를 가지고온다.
        List<String> itemList = itemRepository.getItemList(today(), beforeToday()); // => 하나의 코드조각단위

        // 그냥 뭐 이런 로직이 있다고 가정하자.
        checkItemListByUserId checkItemListByUserId = new checkItemListByUserId();
        List<String> checkedItemList = checkItemListByUserId.check(userInfo,itemList); // => 하나의 코드조각단위

        // 또 뽑힌 아이템중에서 특정 아이템만 골라낸다고 가정해보자.
        List<String> classifiedItem= checkItemListByUserId.classifyItem(new classifyItemByItemCode(),checkedItemList); // => 하나의 코드조각단위

        // 받은 아이템으로 할인율을 계산하는 로직
        String discountRate = new CalculateDiscountRate().calculateDisCountRate(classifiedItem); // => 하나의 코드조각단위

        // 마지막으로 고객할인율 고객할인율테이블에 저장한다.
        itemRepository.saveDiscountRate(userId,discountRate); // => 하나의 코드조각단위

        // 받은 아이템으로 할인율을 계산하는 로직
        return discountRate;
    }

    // 1.
    // 저기서 이렇게 여러가지 단계로 나누는것보다
    // 어떤 하나의 class 해서 그안에 계단형식으로하는게 낫지않을까라는 생각이든다.
    // 그러니까 예를들어서 calculateDiscountRate 이 class 안에서 필요한 파라미터를 받고 그안에서 의존관계를 형성하여 계속 비즈니스로직을 이어가기.
    // 이게 나을수도있는게 위에 로직은 어떻게보면 함수형코어같은 느낌이라 싱글톤으로 들어가게될거라고 생각된다.
    // 왜냐면 나중에 서비스 매서드가 많아지면 이런 싱글톤클래스에대한 의존관계가 많아지고 이는 곧 테스트하기 굉장히 힘들어진다.(생성자로 몇개를 주입시켜줘야되는겨..) => 나중에 한번 생각해보자.

    // 2.
    // 하나의 코드조각 단위를 테스트하는것이 바로 unitTest 이다.
    // 중요한건 그거다 코드조각단위를 검사하는데 안에 내부구현까지 목으로써 처리해줄 필요가없다.
    // 예를들면 ItemService.getItemList 이놈을 만약에 유닛테스트 한다고하면
    // 런던파로 ItemService.getItemList 안에 checkItemListByUserId.check 이게 한번 호출되야되고 값은 뭐가나와야되며,등등 내부로직을 신경쓸필요가 단 1도없다.
    // Controller 입장에서는 그것은 안에 내부구현이기 때문이다.

    // 3.
    // 하나의 코드조각 단위를 테스트하는것을 목표로 한다.
    // 입출력코드방식이 가장 이상적이다.
    // 또 도메인로직을 보면 외부 프로세스로직과 정말 완전히 '분리'되어있다.
    // 그냥 List,Sting 등등 내부 도메인 '계층끼리만 소통'한다.
    // 완전히 '독립적'이다.
    // 목을 쓸필요도없다.

    String today(){
        return "202302011344";
    }

    String beforeToday(){
        return "202301011344";
    }
}
