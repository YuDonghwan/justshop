package dong.shop.delivery;

import lombok.ToString;

import java.util.Random;
import java.util.UUID;

@ToString
public class Delivery {

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
