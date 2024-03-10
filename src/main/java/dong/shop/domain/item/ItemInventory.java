package dong.shop.domain.item;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@SequenceGenerator(
        name="ITEM_INVENTORY_SEQ_GEN",
        sequenceName="ITEM_INVENTORY_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Entity
public class ItemInventory {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_INVENTORY_SEQ_GEN"
    )
    @Column(name = "item_inventory_id")
    private Long id;
    private int count;
    @OneToOne(fetch = FetchType.LAZY)
    private Item item;
    @Enumerated(EnumType.STRING)
    private InventoryStatus inventoryStatus;
}
