package dong.shop.web.shop;

import dong.shop.domain.item.Item;
import dong.shop.domain.item.ItemRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ItemRepository itemRepository;

    @GetMapping("/shopList")
    public String shopList(Model model, HttpServletRequest request) {

        List<Item> items = itemRepository.findItemAll();
        model.addAttribute("items",items);

        return "/shop/shopList";
    }

    @GetMapping("/shopDetail/{itemId}")
    public String shopDetail(@PathVariable Long itemId, Model model, HttpServletRequest request) {

        Item item = itemRepository.findItemById(itemId);
        request.setAttribute("item",item);

        return "/shop/shopDetail";
    }

    @GetMapping("/layout")
    public String layout() {
        return "/layout/layoutTest";
    }

}
