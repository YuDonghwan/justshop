package dong.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member save(MemberDto memberDto) {
        Member newMember = Member.of(memberDto);
        return memberRepository.save(newMember);
    }

    public Member findByid(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
