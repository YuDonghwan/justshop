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
    private MemberStatus memberStatus;
    private Account account;

    public Member() {
    }

    public Member(String username, MemberStatus memberStatus) {
        this.username = username;
        this.memberStatus = memberStatus;
    }
}
