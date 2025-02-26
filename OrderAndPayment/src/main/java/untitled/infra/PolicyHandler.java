package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    OrderNotificationRepository orderNotificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancelled'"
    )
    public void wheneverOrderCancelled_OrderCancellationNotificationPolicy(
        @Payload OrderCancelled orderCancelled
    ) {
        OrderCancelled event = orderCancelled;
        System.out.println(
            "\n\n##### listener OrderCancellationNotificationPolicy : " +
            orderCancelled +
            "\n\n"
        );
        // Comments //
        //주문이 취소되었을 때, Order aggregate에서 발생한 evt-orderCancelled 이벤트를 감지하여 OrderNotification aggregate의 cmd-notifyOrderCancellation 명령을 실행함으로써 고객 및 관련 시스템에 취소 알림을 자동으로 전달하여 후속 처리가 원활하도록 합니다.

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentCancelled'"
    )
    public void wheneverPaymentCancelled_PaymentCancellationOrderCancellationPolicy(
        @Payload PaymentCancelled paymentCancelled
    ) {
        PaymentCancelled event = paymentCancelled;
        System.out.println(
            "\n\n##### listener PaymentCancellationOrderCancellationPolicy : " +
            paymentCancelled +
            "\n\n"
        );
        // Comments //
        //Payment aggregate에서 발생한 evt-paymentCancelled 이벤트를 기반으로 Order aggregate의 cmd-cancelOrder 명령이 실행되도록 하여, 결제 취소가 발생한 경우 자동으로 주문을 취소하고 시스템의 일관성을 유지하며 후속 알림 절차가 진행되도록 합니다.

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryIssueReported'"
    )
    public void wheneverDeliveryIssueReported_DeliveryIssueNotificationPolicy(
        @Payload DeliveryIssueReported deliveryIssueReported
    ) {
        DeliveryIssueReported event = deliveryIssueReported;
        System.out.println(
            "\n\n##### listener DeliveryIssueNotificationPolicy : " +
            deliveryIssueReported +
            "\n\n"
        );
        // Comments //
        //배달 진행 중 문제가 발생하면, 해당 문제를 관리자에게 자동으로 보고하여 신속한 후속 조치 및 추가 확인이 가능하도록 하기 위함입니다.

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
