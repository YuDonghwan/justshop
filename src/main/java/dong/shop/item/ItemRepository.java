package dong.shop.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {

    private static Map<Long, Item> itemStore = new ConcurrentHashMap<>();
    private static Long itemSequence = 1L;

    public Item saveItem(Item item) {
        itemStore.put(itemSequence, item);
        ++itemSequence;
        return item;
    }

    public Item findItembyId(Long id) {
        return itemStore.get(id);
    }

    public List<Item> findItemAll() {return new ArrayList<>(itemStore.values());}
}
