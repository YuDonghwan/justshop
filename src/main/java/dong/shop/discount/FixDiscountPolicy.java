package dong.shop.discount;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountPrice = 3000;
    @Override
    public int discount(int price) {
        return price - discountPrice;
    }
}
