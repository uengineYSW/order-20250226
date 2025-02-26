package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class OrderDetailsQuery {

    private String customerId;
    private OrderStatus orderStatus;
    private Double totalAmount;
}
