package dong.shop.order;

import dong.shop.domain.discount.DiscountPolicy;
import dong.shop.domain.item.Item;
import dong.shop.domain.item.MemoryItemRepository;
import dong.shop.domain.member.Member;
import dong.shop.domain.order.Order;
import dong.shop.domain.order.OrderRepository;
import dong.shop.domain.order.OrderService;
import dong.shop.web.member.MemberUpdateDto;
import dong.shop.domain.member.MemberService;
import dong.shop.web.order.OrderRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private  MemberService memberService;
    @Autowired
    private MemoryItemRepository itemRepository;
    @Autowired
    private  DiscountPolicy discountPolicy;


    @BeforeEach
    void addMember() {
        System.out.println("OrderServiceTest.addMember");

        MemberUpdateDto userA = new MemberUpdateDto("usera", "1234", "userA", "서울");
        MemberUpdateDto userB = new MemberUpdateDto("userb", "1234", "userB", "부산");
        MemberUpdateDto userC = new MemberUpdateDto("userc", "1234", "userC", "대구");

        MemberUpdateDto.of("userD","1234","userD","대전");

        memberService.save(userA);
        memberService.save(userB);
        memberService.save(userC);

        Item item1 = new Item(1L, "사과", 10000,1);
        Item item2 = new Item(2L, "배", 13000,2);
        Item item3 = new Item(3L, "귤", 10000,3);

         itemRepository.saveItem(item1);
         itemRepository.saveItem(item2);
         itemRepository.saveItem(item3);

    }

    @Test
    void createOrderTest() {
        Member findMember = memberService.findByid(1L);
        Item item = itemRepository.findItemById(1L);
        OrderRequestDto orderRequestDto = new OrderRequestDto(findMember, item, 10);
        Order order = orderService.createOrder(orderRequestDto);

        System.out.println(order);
        Assertions.assertThat(order.getItem()).isEqualTo(item);
    }

}