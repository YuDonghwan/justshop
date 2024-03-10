package dong.shop.domain.member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@SequenceGenerator(
        name="MEMBER_SEQ_GEN",
        sequenceName="MEMBER_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Entity
public class Member {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GEN"
    )
    @Column(name = "member_id")
    private Long id;
    private String userId;
    private String password;
    private String username;
    private String address;
    private MemberStatus memberStatus;

    @Embedded
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
