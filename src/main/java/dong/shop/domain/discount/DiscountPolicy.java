package dong.shop.domain.discount;

import dong.shop.domain.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
