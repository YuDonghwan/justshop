package dong.shop.domain.item;

import dong.shop.web.item.ItemSaveDto;
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


}
