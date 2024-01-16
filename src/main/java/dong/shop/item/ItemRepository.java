package dong.shop.item;

import dong.shop.member.Member;

import java.util.List;

public interface ItemRepository {

    Item saveItem(Item item);
    Item findItemById(Long itemId);
    List<Item> findItemAll();
}
