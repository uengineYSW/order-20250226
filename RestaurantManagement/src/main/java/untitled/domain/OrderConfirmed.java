package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderConfirmed extends AbstractEvent {

    private RestaurantOrderStatus newStatus;
    private Date confirmedAt;

    public OrderConfirmed(Restaurant aggregate) {
        super(aggregate);
    }

    public OrderConfirmed() {
        super();
    }
}
//>>> DDD / Domain Event
