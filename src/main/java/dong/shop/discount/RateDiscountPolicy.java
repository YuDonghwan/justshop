package dong.shop.discount;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountRate = 10;


    @Override
    public int discount(int price) {
        return price - price * (discountRate / 100);
    }
}
