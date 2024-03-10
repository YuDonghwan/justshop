package dong.shop.domain.item;

import dong.shop.domain.cmm.CmmFile;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@SequenceGenerator(
        name="ITEM_SEQ_GEN",
        sequenceName="ITEM_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Entity
public class Item {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_SEQ_GEN"
    )
    @Column(name = "item_id")
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;
    private String info;
    private ItemStatus itemStatus;

    @Builder
    public Item(Long id, String itemName, Integer price, Integer quantity, String info, ItemStatus itemStatus, CmmFile fileImage) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.info = info;
        this.itemStatus = itemStatus;
    }

    public Item() {
    }
}
