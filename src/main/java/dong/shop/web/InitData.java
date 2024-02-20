package dong.shop.web;

import dong.shop.domain.cmm.CmmFile;
import dong.shop.domain.item.Item;
import dong.shop.domain.item.ItemRepository;
import dong.shop.domain.item.ItemStatus;
import dong.shop.domain.member.Account;
import dong.shop.domain.member.Member;
import dong.shop.domain.member.MemberRepository;
import dong.shop.domain.member.MemberStatus;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitData {
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {

        CmmFile appleImage = new CmmFile(1L,"png","apple.png","apple.png",1232L,"img/apple.png", LocalDateTime.now(),"FR");
        CmmFile mandarinImage = new CmmFile(2L,"png","mandarin.png","mandarin.png",1232L,"img/mandarin.png", LocalDateTime.now(),"FR");
        CmmFile plumImage = new CmmFile(3L,"png","plum.png","plum.png",1232L,"img/plum.png", LocalDateTime.now(),"FR");
        CmmFile peachImage = new CmmFile(4L,"png","peach.png","peach.png",1232L,"img/peach.png", LocalDateTime.now(),"FR");

        itemRepository.saveItem(new Item(1L,"사과",10000,10,"사과를 할떈 사과를 건네세요", ItemStatus.BASIC,appleImage));
        itemRepository.saveItem(new Item(2L,"귤",16000,10,"제주도에서 가져온듯하지만 대전에서 가져온 귤", ItemStatus.BASIC,mandarinImage));
        itemRepository.saveItem(new Item(3L,"복숭아",45000,10,"청도에서 가져온 새콤달콤 딱복숭아", ItemStatus.BASIC, peachImage));
        itemRepository.saveItem(new Item(4L,"자두",8000,10,"자두자두 생각나는 자두",  ItemStatus.BASIC, plumImage));

        Member member = new Member(1L,"test","test!","userA","서울 천호동", MemberStatus.BASIC,new Account());
        Member admin = new Member(2L,"aaa","1234","userA","서울 천호동", MemberStatus.ADMIN,new Account());

        memberRepository.save(member);
        memberRepository.save(admin);
    }

}
