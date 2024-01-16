package dong.shop.discount;

import dong.shop.member.Member;
import org.springframework.stereotype.Component;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
