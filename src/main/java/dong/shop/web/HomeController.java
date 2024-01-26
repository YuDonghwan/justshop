package dong.shop.web;

import dong.shop.domain.item.Item;
import dong.shop.domain.item.ItemRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ItemRepository itemRepository;


    @GetMapping("/")
    public String home(HttpServletRequest request, HttpServletResponse response, Model model) {

        List<Item> items = itemRepository.findItemAll();
        model.addAttribute("items",items);

        return "/index";
    }

}
