package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderCreatedNotified extends AbstractEvent {

    private String notificationId;
    private String notificationType;
    private Date notifiedAt;

    public OrderCreatedNotified(OrderNotification aggregate) {
        super(aggregate);
    }

    public OrderCreatedNotified() {
        super();
    }
}
//>>> DDD / Domain Event
