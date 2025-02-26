package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class OrderNotificationSummaryQuery {

    private String notificationId;
    private String notificationType;
    private Date notifiedAt;
}
