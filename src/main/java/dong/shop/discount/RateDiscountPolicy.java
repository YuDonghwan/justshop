package dong.shop.discount;

import dong.shop.member.Member;
import dong.shop.member.MemberStatus;

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
