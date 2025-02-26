package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class AssignedDeliveryOrdersQuery {

    private String assignedDeliverer;
    private DeliveryStatus deliveryStatus;
}
