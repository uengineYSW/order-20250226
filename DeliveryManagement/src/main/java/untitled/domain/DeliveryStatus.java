package untitled.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


public enum DeliveryStatus {

    Assigned,
    In Transit,
    Delivered,
    Cancelled;

}
