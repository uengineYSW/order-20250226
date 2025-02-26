package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PaymentSummaryQuery {

    private Double amount;
    private PaymentStatus paymentStatus;
}
