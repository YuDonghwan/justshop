package dong.shop.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryItemRepository implements ItemRepository{

    private static Map<Long, Item> itemStore = new ConcurrentHashMap<>();
    private static Long itemSequence = 1L;

    @Override
    public Item saveItem(Item item) {
        itemStore.put(itemSequence, item);
        ++itemSequence;
        return item;
    }


    @Override
    public Item findItemById(Long itemId) {
        return itemStore.get(itemId);
    }

    @Override
    public List<Item> findItemAll() {return new ArrayList<>(itemStore.values());}

    @Override
    public Item updateItem(Item item) {
        itemStore.put(item.getItemId(), item);
        return itemStore.get(item.getItemId());
    }


}
