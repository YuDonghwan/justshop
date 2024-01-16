package dong.shop.order;

import dong.shop.delivery.Delivery;
import dong.shop.item.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
public class Order {

    private Long id;
    private Long itemId;
    private int count;
    private int totalPrice;
    private Delivery delivery;
    private Long memberId;

    private List<Item> buyItems;


    public Order() {
    }
    public Order(Long itemId, int totalPrice, Long memberId) {
        this(itemId, totalPrice, new Delivery(), memberId);
    }

    public Order(Long itemId, int totalPrice, Delivery delivery, Long memberId) {
        this.itemId = itemId;
        this.totalPrice = totalPrice;
        this.delivery = delivery;
        this.memberId = memberId;
    }
}
