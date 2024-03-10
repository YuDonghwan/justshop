package dong.shop.domain.member;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Account {

    private int account;

    public void plusAccount(int cash) {
        account += cash;
    }
    public void minusAccount(int cash) {
        account -= cash;
    }

}
