package dong.shop.domain.delivery;

import dong.shop.domain.cmm.Address;
import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@ToString
@Entity
@SequenceGenerator(
        name = "DELIVERY_SEQ_GEN",
        sequenceName = "ORDER_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class Delivery {

    @Id @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "DELIVERY_SEQ_GEN"
    )
    @Column(name = "delivery_id")
    private Long id;

    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    private LocalDateTime start_dt;
    private LocalDateTime comp_dt;

    private String companyName;
    private String wayBillNumber;

    public String callCompanyName() {
        String[] companys = {"우체국 택배","한진택배","CJ대한통운","롯데택배","경동택배","로젠택배","GS25편의점택배"};
        return companys[new Random().nextInt(7)];
    }

    public String generateWayBillNum() {
        return UUID.randomUUID().toString();
    }

    public Delivery() {
        companyName = callCompanyName();
        wayBillNumber = generateWayBillNum();
    }
}
