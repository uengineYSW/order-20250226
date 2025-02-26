package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/deliveries")
@Transactional
public class DeliveryController {

    @Autowired
    DeliveryRepository deliveryRepository;

    @RequestMapping(
        value = "/deliveries",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Delivery pickupOrder(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody PickupOrderCommand pickupOrderCommand
    ) throws Exception {
        System.out.println("##### /delivery/pickupOrder  called #####");
        Delivery delivery = new Delivery();
        delivery.pickupOrder(pickupOrderCommand);
        deliveryRepository.save(delivery);
        return delivery;
    }

    @RequestMapping(
        value = "/deliveries/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Delivery updateDeliveryStatus(
        @PathVariable(value = "id") Long id,
        @RequestBody UpdateDeliveryStatusCommand updateDeliveryStatusCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /delivery/updateDeliveryStatus  called #####"
        );
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(id);

        optionalDelivery.orElseThrow(() -> new Exception("No Entity Found"));
        Delivery delivery = optionalDelivery.get();
        delivery.updateDeliveryStatus(updateDeliveryStatusCommand);

        deliveryRepository.save(delivery);
        return delivery;
    }

    @RequestMapping(
        value = "/deliveries/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Delivery deliverOrder(
        @PathVariable(value = "id") Long id,
        @RequestBody DeliverOrderCommand deliverOrderCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /delivery/deliverOrder  called #####");
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(id);

        optionalDelivery.orElseThrow(() -> new Exception("No Entity Found"));
        Delivery delivery = optionalDelivery.get();
        delivery.deliverOrder(deliverOrderCommand);

        deliveryRepository.save(delivery);
        return delivery;
    }

    @RequestMapping(
        value = "/deliveries",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Delivery reportIssue(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ReportIssueCommand reportIssueCommand
    ) throws Exception {
        System.out.println("##### /delivery/reportIssue  called #####");
        Delivery delivery = new Delivery();
        delivery.reportIssue(reportIssueCommand);
        deliveryRepository.save(delivery);
        return delivery;
    }
}
//>>> Clean Arch / Inbound Adaptor
