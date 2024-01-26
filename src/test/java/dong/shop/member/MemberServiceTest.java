package dong.shop.member;

import dong.shop.domain.member.Member;
import dong.shop.domain.member.MemberService;
import dong.shop.web.member.MemberUpdateDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @BeforeEach
    void addMember() {
        System.out.println("OrderServiceTest.addMember");

        MemberUpdateDto userA = new MemberUpdateDto("usera", "1234", "userA", "서울");
        MemberUpdateDto userB = new MemberUpdateDto("userb", "1234", "userB", "부산");
        MemberUpdateDto userC = new MemberUpdateDto("userc", "1234", "userC", "대구");

        MemberUpdateDto.of("userD","1234","userD","대전");

        memberService.save(userA);
        memberService.save(userB);
        memberService.save(userC);
    }
    @Test
    void saveMember() {
        MemberUpdateDto userE = new MemberUpdateDto("usere", "1234", "userE", "서울");
        Member savedMember = memberService.save(userE);

        Assertions.assertThat(savedMember.getAccount().getAccount()).isEqualTo(0);
    }

}