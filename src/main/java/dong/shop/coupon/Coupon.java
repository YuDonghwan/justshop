package dong.shop.coupon;

import java.time.LocalDateTime;

public class Coupon {

    private Long couponId;
    private String couponName;
    private int couponCount;

    private int discountRate;

    // 종료날짜
    private LocalDateTime deadLineDt;

    // 배포날짜
    private LocalDateTime distributionDt;

}
