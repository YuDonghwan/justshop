package dong.shop.domain.order;

import dong.shop.domain.delivery.Delivery;
import dong.shop.domain.discount.DiscountPolicy;
import dong.shop.domain.item.MemoryItemRepository;
import dong.shop.domain.member.MemberService;
import dong.shop.web.order.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberService memberService;
    private final MemoryItemRepository itemRepository;
    private final DiscountPolicy discountPolicy;

    public Order createOrder(OrderRequestDto orderRequestDto) {

        int totalPrice = orderRequestDto.getTotalPrice();
        int resultPrice = discountPolicy.discount(orderRequestDto.getMember(), totalPrice);
        Delivery delivery = new Delivery();

        return new Order(orderRequestDto.getCount(),resultPrice,delivery,orderRequestDto.getMember());
    }

}
