package dong.shop.member;

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


    public static Member of(MemberDto mDto) {
        return Member.builder()
                .userId(mDto.getUserId())
                .password(mDto.getPassword())
                .username(mDto.getUsername())
                .account(mDto.getAccount())
                .memberStatus(mDto.getMemberStatus())
                .build();
    }
}
