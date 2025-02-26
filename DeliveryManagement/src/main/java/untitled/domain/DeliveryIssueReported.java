package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryIssueReported extends AbstractEvent {

    private Long id;
    private String issueReport;
    private Date reportedAt;

    public DeliveryIssueReported(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryIssueReported() {
        super();
    }
}
//>>> DDD / Domain Event
