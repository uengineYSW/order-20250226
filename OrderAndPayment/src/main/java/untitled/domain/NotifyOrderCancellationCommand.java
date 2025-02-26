package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class NotifyOrderCancellationCommand {

    private String cancellationReason;
}
