package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.OrderAndPaymentApplication;

@Entity
@Table(name = "OrderNotification_table")
@Data
//<<< DDD / Aggregate Root
public class OrderNotification {

    @Id
    private String notificationId;

    private String notificationType;

    private Date notifiedAt;

    public static OrderNotificationRepository repository() {
        OrderNotificationRepository orderNotificationRepository = OrderAndPaymentApplication.applicationContext.getBean(
            OrderNotificationRepository.class
        );
        return orderNotificationRepository;
    }

    //<<< Clean Arch / Port Method
    public void notifyOrderCreated() {
        //implement business logic here:

        OrderCreatedNotified orderCreatedNotified = new OrderCreatedNotified(
            this
        );
        orderCreatedNotified.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void notifyOrderCancellation(
        NotifyOrderCancellationCommand notifyOrderCancellationCommand
    ) {
        //implement business logic here:

        OrderCancelledNotified orderCancelledNotified = new OrderCancelledNotified(
            this
        );
        orderCancelledNotified.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
