package dong.shop.domain.discount;

import dong.shop.domain.member.Member;
import dong.shop.domain.member.MemberStatus;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountRate = 10;


    @Override
    public int discount(Member member, int price) {

        if(member.getMemberStatus() == MemberStatus.VIP) {
            return price - (price * (discountRate/100));
        }

        return price;
    }
}
