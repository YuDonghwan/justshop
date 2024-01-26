package dong.shop.domain.item;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Item {

    private Long itemId;
    private String itemName;
    private Integer price;
    private Integer quantity;
    private String info;

    private ItemStatus itemStatus;

    public Item() {
    }

    public Item(Long itemId, String itemName, Integer price, Integer quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(Long itemId, String itemName, Integer price,String info,Integer quantity) {
        this(itemId, itemName, price, quantity);
        this.info = info;
    }

    public Item(Long itemId, String itemName, Integer price, Integer quantity, String info, ItemStatus itemStatus) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.info = info;
        this.itemStatus = itemStatus;
    }

    public static Item of(String itemName, Integer price, Integer quantity, String info) {
        return Item.builder()
                .itemName(itemName)
                .price(price)
                .quantity(quantity)
                .info(info)
                .build();
    }
}
