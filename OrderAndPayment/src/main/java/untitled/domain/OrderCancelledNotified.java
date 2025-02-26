package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderCancelledNotified extends AbstractEvent {

    private String notificationId;
    private String notificationType;
    private Date notifiedAt;

    public OrderCancelledNotified(OrderNotification aggregate) {
        super(aggregate);
    }

    public OrderCancelledNotified() {
        super();
    }
}
//>>> DDD / Domain Event
