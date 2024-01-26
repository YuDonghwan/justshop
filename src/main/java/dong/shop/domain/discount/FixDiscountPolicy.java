package dong.shop.domain.discount;

import dong.shop.domain.member.Member;
import dong.shop.domain.member.MemberStatus;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountPrice = 3000;
    @Override
    public int discount(Member member, int price) {

        if(member.getMemberStatus() == MemberStatus.VIP) {
            return price - discountPrice;
        }
        System.out.println("FixDiscountPolicy.noDiscount");
        return price;
    }
}
