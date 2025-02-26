package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryPickedUp extends AbstractEvent {

    private Long id;
    private Date pickupTime;
    private DeliveryStatus deliveryStatus;

    public DeliveryPickedUp(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryPickedUp() {
        super();
    }
}
//>>> DDD / Domain Event
