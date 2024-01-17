package dong.shop.member;

import dong.shop.config.AppConfig;
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
//    MemberService memberService = new MemberService(new MemorymemberRepository());

//    @BeforeEach
//    void beforeEach() {
//        ApplicationContext ac = new AnnotationConfigApplicationContext();
//
//    }


    @Test
    void saveMember() {
//        Member member = new Member();
//        member.setMemberStatus(MemberStatus.BASIC);
//        member.setId(1L);
//        member.setUserId("user1");
//        member.setUsername("userA");
//        member.setPassword("1234");
//        System.out.println("MemberServiceTest.saveMember");
//        Member savedMember = memberService.save(member);
//
//        Assertions.assertThat(member).isEqualTo(savedMember);
    }

}