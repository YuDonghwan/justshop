package dong.shop.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item {

    private Long itemId;
    private String itemName;
    private Integer price;
    private String info;
    private ItemStatus itemStatus;

    public Item() {
    }

    public Item(Long itemId, String itemName, Integer price, ItemStatus itemStatus) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.itemStatus = itemStatus;
    }
}
