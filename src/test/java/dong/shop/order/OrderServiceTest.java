package dong.shop.order;

import dong.shop.discount.DiscountPolicy;
import dong.shop.item.Item;
import dong.shop.item.ItemRepository;
import dong.shop.item.ItemStatus;
import dong.shop.member.Member;
import dong.shop.member.MemberService;
import dong.shop.member.MemberStatus;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class OrderServiceTest {

    @Autowired
    private  OrderService orderService;
    @Autowired
    private  OrderRepository orderRepository;
    @Autowired
    private  MemberService memberService;
    @Autowired
    private  ItemRepository itemRepository;
    @Autowired
    private  DiscountPolicy discountPolicy;


    @BeforeEach
    void addMember() {
        System.out.println("OrderServiceTest.addMember");
        Member userA = new Member("userA", MemberStatus.VIP);
        Member userB = new Member("userB", MemberStatus.BASIC);
        Member userC = new Member("userC", MemberStatus.ADMIN);

        memberService.save(userA);
        memberService.save(userB);
        memberService.save(userC);

        Item item1 = new Item(1L, "사과", 10000, ItemStatus.BASIC);
        Item item2 = new Item(2L, "배", 13000, ItemStatus.BASIC);
        Item item3 = new Item(3L, "귤", 10000, ItemStatus.BASIC);

         itemRepository.saveItem(item1);
         itemRepository.saveItem(item2);
         itemRepository.saveItem(item3);

    }

    @Test
    void createOrderTest() {
        Member findMember = memberService.findByid(1L);
        Item item = itemRepository.findItembyId(1L);
        OrderRequestDto orderRequestDto = new OrderRequestDto(findMember, item, 10);
        Order order = orderService.createOrder(orderRequestDto);

        System.out.println(order);
        Assertions.assertThat(order.getItem()).isEqualTo(item);
    }

}