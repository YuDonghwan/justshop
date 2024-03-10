package dong.shop.domain.order;

import dong.shop.domain.delivery.Delivery;
import dong.shop.domain.item.Item;
import dong.shop.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@Entity
@SequenceGenerator(
        name="ORDER_SEQ_GEN",
        sequenceName="ORDER_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ORDER_SEQ_GEN"
    )
    @Column(name = "order_id")
    private Long id;
    private int itemCount;
    private int totalPrice;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    private OrderStatus orderStatus;


    public Order() {
    }

    public Order( int count, int totalPrice, Delivery delivery, Member member) {
        this.delivery = delivery;
        this.member = member;
    }
}
