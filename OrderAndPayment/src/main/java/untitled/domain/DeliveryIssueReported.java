package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class DeliveryIssueReported extends AbstractEvent {

    private Long id;
    private String issueReport;
    private Date reportedAt;
}
