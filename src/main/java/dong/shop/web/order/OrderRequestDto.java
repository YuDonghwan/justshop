package dong.shop.web.order;

import dong.shop.delivery.Delivery;
import dong.shop.item.Item;
import dong.shop.member.Member;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class OrderRequestDto {

    private Member member;
    private Item item;
    private int count;
    public int getTotalPrice() {
        return item.getPrice() * count;
    }

    public OrderRequestDto(Member member, Item item, int count) {
        this.member = member;
        this.item = item;
        this.count = count;
    }
}
