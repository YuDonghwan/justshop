package dong.shop.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
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
        this.account = new Account();
    }

    public MemberDto(String userId, String password, String username, String address, Account account, MemberStatus memberStatus) {
        this(userId,password,username,address);
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
