package dong.shop.domain.coupon;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@SequenceGenerator(
        name="COUPON_SEQ_GEN",
        sequenceName="COUPON_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class Coupon {

    @Id @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "COUPON_SEQ_GEN"
    )
    private Long id;
    private String couponName;
    private int couponCount;

    private int couponVal;

    //사용가능날짜
    private LocalDateTime startDt;
    // 종료날짜
    private LocalDateTime deadLineDt;

    // 배포날짜
    private LocalDateTime distributionDt;

}
