package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryStatusUpdated extends AbstractEvent {

    private Long id;
    private DeliveryStatus newStatus;

    public DeliveryStatusUpdated(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryStatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
