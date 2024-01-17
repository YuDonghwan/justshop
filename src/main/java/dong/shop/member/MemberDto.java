package dong.shop.member;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDto {
    private Long id;
    private String userId;
    private String password;
    private String username;
    private String address;
    private Account account;
    private MemberStatus memberStatus;

    public MemberDto(String userId, String password, String username, String address) {
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.address = address;
        this.memberStatus = MemberStatus.BASIC;
    }

    public MemberDto(Long id, String userId, String password, String username, String address, Account account, MemberStatus memberStatus) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.address = address;
        this.account = account;
        this.memberStatus = memberStatus;
    }

    //테스트용 builder
    public static MemberDto of(String userId, String password, String username, String address) {
        return MemberDto.builder()
                .userId(userId)
                .password(password)
                .username(username)
                .address(address)
                .memberStatus(MemberStatus.BASIC)
                .build();
    }
}
