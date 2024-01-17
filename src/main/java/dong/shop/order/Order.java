package dong.shop.order;

import dong.shop.delivery.Delivery;
import dong.shop.item.Item;
import dong.shop.member.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
public class Order {

    private Long id;
    private Item item;
    private int itemCount;
    private int totalPrice;
    private Delivery delivery;
    private Member member;
    private OrderStatus orderStatus;


    public Order() {
    }

    public Order(Item item, int count, int totalPrice, Delivery delivery, Member member) {
        this.item = item;
        this.itemCount = itemCount;
        this.totalPrice = totalPrice;
        this.delivery = delivery;
        this.member = member;
    }
}
