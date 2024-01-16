package dong.shop.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/")
    public String items(Model model) {
        List<Item> items = itemService.selectAllItems();
        model.addAttribute("items",items);
        return "/item/items";
    }
    @GetMapping("/addItem")
    public String addItem() {
        return "/item/addItem";
    }

    @PostMapping("/addItem")
    public String saveItem(Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        //검증 로직 추가



        //성공 시
        return "/item/itemDetail";
    }
}
