package dong.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final MemoryItemRepository itemRepository;

    public List<Item> selectAllItems() {
        return itemRepository.findItemAll();
    }

}
