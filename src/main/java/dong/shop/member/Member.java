package dong.shop.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;
    private String userId;
    private String password;
    private String username;
    private MemberStatus memberStatus;
    private Account account;

}
