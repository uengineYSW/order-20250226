package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PickupOrderCommand {

    private Long id;
    private Date pickupTime;
}
