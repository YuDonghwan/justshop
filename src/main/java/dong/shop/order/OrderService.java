package dong.shop.order;

import dong.shop.delivery.Delivery;
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

    public Order createOrder(OrderRequestDto orderRequestDto) {

        int totalPrice = orderRequestDto.getTotalPrice();
        int resultPrice = discountPolicy.discount(orderRequestDto.getMember(), totalPrice);
        Delivery delivery = new Delivery();

        return new Order(orderRequestDto.getItem(),orderRequestDto.getCount(),resultPrice,delivery,orderRequestDto.getMember());
    }

}
