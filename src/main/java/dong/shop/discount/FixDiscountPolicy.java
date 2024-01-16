package dong.shop.discount;

import dong.shop.member.Member;
import dong.shop.member.MemberStatus;
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
