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

    public Item(Long itemId, String itemName, Integer price, ItemStatus itemStatus) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.itemStatus = itemStatus;
    }

    public Item(Long itemId, String itemName, Integer price, ItemStatus itemStatus,String info) {
        this(itemId, itemName, price, itemStatus);
        this.info = info;
    }


    public static Item of(String itemName, Integer price, String info, ItemStatus itemStatus) {
        return Item.builder()
                .itemName(itemName)
                .price(price)
                .itemStatus(itemStatus)
                .info(info)
                .build();
    }
}
