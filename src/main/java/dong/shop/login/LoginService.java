package dong.shop.login;

import dong.shop.member.Member;
import dong.shop.member.MemberRepository;
import dong.shop.member.MemorymemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemorymemberRepository memberRepository;

    public Member login(String loginId, String password) {

        memberRepository.findMemberByLoginId(loginId)
                        .filter(m -> m.getPassword().equals(password))
                        .orElse(null);
    }
}
