package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateOrderCommand {

    private String customerId;
    private Double totalAmount;
}
