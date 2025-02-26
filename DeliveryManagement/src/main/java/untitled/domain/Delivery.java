package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.DeliveryManagementApplication;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private DeliveryStatus deliveryStatus;

    private String assignedDeliverer;

    private Date pickupTime;

    private Date deliveryTime;

    private String issueReport;

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryManagementApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public void pickupOrder(PickupOrderCommand pickupOrderCommand) {
        //implement business logic here:

        DeliveryPickedUp deliveryPickedUp = new DeliveryPickedUp(this);
        deliveryPickedUp.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updateDeliveryStatus(
        UpdateDeliveryStatusCommand updateDeliveryStatusCommand
    ) {
        //implement business logic here:

        DeliveryStatusUpdated deliveryStatusUpdated = new DeliveryStatusUpdated(
            this
        );
        deliveryStatusUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void deliverOrder(DeliverOrderCommand deliverOrderCommand) {
        //implement business logic here:

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void reportIssue(ReportIssueCommand reportIssueCommand) {
        //implement business logic here:

        DeliveryIssueReported deliveryIssueReported = new DeliveryIssueReported(
            this
        );
        deliveryIssueReported.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
