package dong.shop.member;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemorymemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new ConcurrentHashMap<>();
    private static Long sequence = 1L;

    @Override
    public Member save(Member member) {
        store.put(sequence, member);
        ++sequence;
        return member;
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Member> findMemberByLoginId(String loginId) {

        return findAll().stream()
                .filter(member -> loginId.equals(member.getUserId()))
                .findFirst();
    }


}
