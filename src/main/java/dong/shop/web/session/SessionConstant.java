package dong.shop.web.session;

import lombok.Getter;

@Getter
public enum SessionConstant {
    LOGIN_MEMBER("log_id");

    private String value;

    SessionConstant(String value) {
        this.value = value;
    }
}
