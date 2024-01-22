package dong.shop.web.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberSaveDto {

    private String userId;
    private String password;
    private String username;
    private String address;
}
