package dong.shop.item;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ItemDto {

    private Long itemId;
    private String itemName;
    private Integer price;
    private String info;
    private ItemStatus itemStatus;

}
