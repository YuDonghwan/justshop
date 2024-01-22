package dong.shop.web.item;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemSaveDto {

    @NotBlank
    private String itemName;
    @NotNull
    private Integer price;
    @NotNull
    @Max(value = 9999)
    private Integer quantity;
    private String info;

}
