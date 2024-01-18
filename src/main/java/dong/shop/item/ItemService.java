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
    public Item updateItem(ItemSaveDto itemDto) {
        Item updateItem = Item.of(itemDto.getItemName(), itemDto.getPrice(),itemDto.getQuantity(), itemDto.getInfo());
        return itemRepository.updateItem(updateItem);
    }

}
