package dong.shop.member;

import dong.shop.config.AppConfig;
import dong.shop.item.Item;
import dong.shop.item.ItemStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberServiceTest {

    @Autowired
   MemberService memberService;

    @BeforeEach
    void addMember() {
        System.out.println("OrderServiceTest.addMember");

        MemberDto userA = new MemberDto("usera", "1234", "userA", "서울");
        MemberDto userB = new MemberDto("userb", "1234", "userB", "부산");
        MemberDto userC = new MemberDto("userc", "1234", "userC", "대구");

        MemberDto.of("userD","1234","userD","대전");

        memberService.save(userA);
        memberService.save(userB);
        memberService.save(userC);
    }
    @Test
    void saveMember() {
        MemberDto userE = new MemberDto("usere", "1234", "userE", "서울");
        Member savedMember = memberService.save(userE);

        Assertions.assertThat(savedMember.getAccount().getAccount()).isEqualTo(0);
    }

}