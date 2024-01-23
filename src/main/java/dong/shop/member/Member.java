package dong.shop.member;

import dong.shop.web.member.MemberUpdateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Member {

    private Long id;
    private String userId;
    private String password;
    private String username;
    private String address;
    private MemberStatus memberStatus;
    private Account account;

    public Member() {
    }

    public Member(String username, MemberStatus memberStatus) {
        this.username = username;
        this.memberStatus = memberStatus;
    }

    public Member(String userId, String password, String username, String address) {
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.address = address;
    }

}
