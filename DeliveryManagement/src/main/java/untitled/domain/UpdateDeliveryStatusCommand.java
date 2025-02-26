package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateDeliveryStatusCommand {

    private Long id;
    private DeliveryStatus newStatus;
}
