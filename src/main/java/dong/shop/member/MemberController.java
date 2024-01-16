package dong.shop.member;

import dong.shop.order.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/client")
    public ResponseEntity<String> client(@RequestBody OrderRequestDto orderDto) {
        System.out.println("orderDto = " + orderDto);
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
