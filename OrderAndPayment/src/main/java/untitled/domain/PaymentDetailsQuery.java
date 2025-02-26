package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PaymentDetailsQuery {

    private Double amount;
    private PaymentStatus paymentStatus;
    private Date completedAt;
    private String cancellationReason;
    private Date cancelledAt;
}
