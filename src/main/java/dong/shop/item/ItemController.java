package dong.shop.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/")
    public String items(Item item , Model model) {
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
        bindingResult.rejectValue("item","required",null,"아이템명은 필수입니다.");

        //성공 시
        return "redirect:/item/itemDetail";
    }

    @GetMapping("/updateItem")
    public String updateItem(Model model) {
        return "/item/updateItem";
    }

    @PostMapping("/updateItem")
    public String editItem(ItemDto itemDto, Model model,RedirectAttributes redirectAttributes) {


        Item updatedItem = itemService.updateItem(itemDto);
        redirectAttributes.addAttribute("updateItem",updatedItem);
        return "redirect:/item/itemDetail";
    }
}
