package dong.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> selectAllItems() {
        return itemRepository.findItemAll();
    }
    public Item updateItem(ItemDto itemDto) {
        Item updateItem = Item.of(itemDto.getItemName(), itemDto.getPrice(), itemDto.getInfo(), itemDto.getItemStatus());
        return itemRepository.updateItem(updateItem);
    }

}
