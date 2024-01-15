package dong.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    Member save(Member member) {
        return memberRepository.save(member);
    }

    Member findByid(Long id) {
        return memberRepository.findById(id);
    }

    List<Member> findAll() {
        return memberRepository.findAll();
    }
}
