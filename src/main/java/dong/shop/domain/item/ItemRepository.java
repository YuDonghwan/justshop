package dong.shop.domain.item;

import java.util.List;

public interface ItemRepository {

    Item saveItem(Item item);
    Item findItemById(Long itemId);
    List<Item> findItemAll();
    Item updateItem(Item item);
}
