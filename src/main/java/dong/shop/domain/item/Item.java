package dong.shop.domain.item;

import dong.shop.domain.cmm.CmmFile;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Item {

    private Long itemId;
    private String itemName;
    private Integer price;
    private Integer quantity;
    private String info;
    private ItemStatus itemStatus;
    private CmmFile fileImage;

    @Builder
    public Item(Long itemId, String itemName, Integer price, Integer quantity, String info, ItemStatus itemStatus, CmmFile fileImage) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.info = info;
        this.itemStatus = itemStatus;
        this.fileImage = fileImage;
    }

    public Item() {
    }
}
