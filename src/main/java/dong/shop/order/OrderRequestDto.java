package dong.shop.order;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class OrderRequestDto {

    private String memberId;
    private String username;
}
