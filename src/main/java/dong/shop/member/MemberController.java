package dong.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/client")
    public ResponseEntity<String> client() {

        Member member = new Member();
        member.setMemberStatus(MemberStatus.BASIC);
        member.setId(1L);
        member.setUserId("user1");
        member.setUsername("userA");
        member.setPassword("1234");

        memberService.save(member);
        return ResponseEntity.ok("ok");
    }
}
