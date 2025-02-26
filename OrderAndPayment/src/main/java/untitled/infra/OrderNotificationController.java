package untitled.infra;
import untitled.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/orderNotifications")
@Transactional
public class OrderNotificationController {
    @Autowired
    OrderNotificationRepository orderNotificationRepository;

    @RequestMapping(value = "/orderNotifications",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public OrderNotification notifyOrderCreated(HttpServletRequest request, HttpServletResponse response, 
        ) throws Exception {
            System.out.println("##### /orderNotification/notifyOrderCreated  called #####");
            OrderNotification orderNotification = new OrderNotification();
            orderNotification.notifyOrderCreated();
            orderNotificationRepository.save(orderNotification);
            return orderNotification;
    }
    @RequestMapping(value = "/orderNotifications",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public OrderNotification notifyOrderCancellation(HttpServletRequest request, HttpServletResponse response, 
        @RequestBody NotifyOrderCancellationCommand notifyOrderCancellationCommand) throws Exception {
            System.out.println("##### /orderNotification/notifyOrderCancellation  called #####");
            OrderNotification orderNotification = new OrderNotification();
            orderNotification.notifyOrderCancellation(notifyOrderCancellationCommand);
            orderNotificationRepository.save(orderNotification);
            return orderNotification;
    }
}
//>>> Clean Arch / Inbound Adaptor
