package dong.shop.member;

import lombok.Getter;

@Getter
public class Account {

    private int account;

    public void plusAccount(int cash) {
        account += cash;
    }
    public void minusAccount(int cash) {
        account -= cash;
    }

}
