package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MenuItemAdded extends AbstractEvent {

    private String itemId;
    private String name;
    private String description;
    private Double price;

    public MenuItemAdded(Restaurant aggregate) {
        super(aggregate);
    }

    public MenuItemAdded() {
        super();
    }
}
//>>> DDD / Domain Event
