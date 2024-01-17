package dong.shop.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Item {

    private Long itemId;
    private String itemName;
    private Integer price;
    private String info;

    private ItemStatus itemStatus;

    public Item() {
    }

    public Item(Long itemId, String itemName, Integer price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
    }

    public Item(Long itemId, String itemName, Integer price,String info) {
        this(itemId, itemName, price);
        this.info = info;
    }

    public Item(Long itemId, String itemName, Integer price, String info, ItemStatus itemStatus) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.info = info;
        this.itemStatus = itemStatus;
    }

    public static Item of(String itemName, Integer price, String info, ItemStatus itemStatus) {
        return Item.builder()
                .itemName(itemName)
                .price(price)
                .info(info)
                .itemStatus(itemStatus)
                .build();
    }
}
