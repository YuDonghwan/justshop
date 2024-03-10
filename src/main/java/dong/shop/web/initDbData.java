package dong.shop.web;

import dong.shop.domain.member.Account;
import dong.shop.domain.member.Member;
import dong.shop.domain.member.MemberStatus;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class initDbData {

    private final EntityManager em;

    @Transactional
    public void init() {
        EntityTransaction tx = em.getTransaction();

        Member member = new Member(1L,"test","test!","userA","서울 천호동", MemberStatus.BASIC,new Account());
        Member admin = new Member(2L,"aaa","1234","userA","서울 천호동", MemberStatus.ADMIN,new Account());

        em.persist(member);
        em.persist(admin);
    }

}
