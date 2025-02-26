package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class OrderSummaryQuery {

    private OrderStatus orderStatus;
    private Double totalAmount;
}
