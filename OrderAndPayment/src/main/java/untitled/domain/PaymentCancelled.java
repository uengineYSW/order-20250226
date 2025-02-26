package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCancelled extends AbstractEvent {

    private String cancellationReason;
    private PaymentStatus paymentStatus;
    private Date cancelledAt;

    public PaymentCancelled(Payment aggregate) {
        super(aggregate);
    }

    public PaymentCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
