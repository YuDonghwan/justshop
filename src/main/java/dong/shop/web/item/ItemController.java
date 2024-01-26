package dong.shop.web.item;

import dong.shop.domain.item.Item;
import dong.shop.domain.item.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public String items(Item item , Model model) {
        List<Item> items = itemService.selectAllItems();
        model.addAttribute("items",items);
        return "/admin/item/items";
    }
    @GetMapping("/addItem")
    public String addItem(@ModelAttribute Item item) {

        return "/admin/item/addItemForm";
    }

    @PostMapping("/addItem")
    public String saveItem(@Validated @ModelAttribute("item") ItemSaveDto item, BindingResult bindingResult, RedirectAttributes redirectAttributes) {


        //특정 필드가 아닌 복합 룰 검증
        if (item.getPrice() != null && item.getQuantity() != null) {
            int resultPrice = item.getPrice() * item.getQuantity();
            if (resultPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{10000,
                        resultPrice}, null);
            }
        }

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "/admin/item/addItemForm";
        }
        log.info("bindingResult = {}", bindingResult);

        //성공 시
        return "redirect:/admin/item/itemDetail";
    }

    @GetMapping("/updateItem")
    public String updateItem(Model model) {
        return "/item/updateItem";
    }

    @PostMapping("/updateItem")
    public String editItem(ItemSaveDto itemDto, Model model, RedirectAttributes redirectAttributes) {


        Item updatedItem = itemService.updateItem(itemDto);
        redirectAttributes.addAttribute("updateItem",updatedItem);
        return "redirect:/admin/item/itemDetail";
    }
}
