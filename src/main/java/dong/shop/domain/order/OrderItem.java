package dong.shop.domain.order;


import dong.shop.domain.item.Item;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@SequenceGenerator(
        name = "ORDER_ITEM_SEQ_GEN",
        sequenceName = "ORDER_ITEM_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Getter
public class OrderItem {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ORDER_ITEM_SEQ_GEN"
    )
    @Column(name = "order_item_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    /*주문당시 아이템 하나의 가격*/
    private int orderPerPrice;
    private int count;
}
