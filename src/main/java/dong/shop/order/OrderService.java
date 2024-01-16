package dong.shop.order;

import dong.shop.discount.DiscountPolicy;
import dong.shop.item.Item;
import dong.shop.item.ItemRepository;
import dong.shop.item.ItemStatus;
import dong.shop.member.Member;
import dong.shop.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberService memberService;
    private final ItemRepository itemRepository;
    private final DiscountPolicy discountPolicy;

    public Order createOrder(Long memberId, Order order) {

        int totalPrice = order.getTotalPrice();

        Item findItem = itemRepository.findItembyId(order.getItemId());

        System.out.println("totalPrice = " + totalPrice);

        return new Order(findItem.getItemId(), 0,memberId);
    }

}
