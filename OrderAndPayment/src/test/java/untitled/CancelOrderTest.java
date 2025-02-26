package untitled;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierMessage;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierMessaging;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierObjectMapper;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeTypeUtils;
import untitled.domain.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMessageVerifier
public class CancelOrderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        CancelOrderTest.class
    );

    @Autowired
    private MessageCollector messageCollector;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MessageVerifier<Message<?>> messageVerifier;

    @Autowired
    public OrderRepository repository;

    @Test
    @SuppressWarnings("unchecked")
    public void test0() {
        //given:
        Order entity = new Order();

        entity.setOrderId("ORD-002");
        entity.setCustomerId("CUST-456");
        entity.setOrderStatus("ORDER_RECEIVED");
        entity.setTotalAmount(75L);
        entity.setRestaurantId("N/A");
        entity.setMenuId("N/A");
        entity.setDeliveryId("N/A");

        repository.save(entity);

        //when:
        try {
            CancelOrderCommand command = new CancelOrderCommand();

            command.setCancellationReason("Customer requested cancellation");

            entity.cancelOrder(command);

            //then:
            this.messageVerifier.send(
                    MessageBuilder
                        .withPayload(entity)
                        .setHeader(
                            MessageHeaders.CONTENT_TYPE,
                            MimeTypeUtils.APPLICATION_JSON
                        )
                        .build(),
                    "untitled"
                );

            Message<?> receivedMessage =
                this.messageVerifier.receive(
                        "untitled",
                        5000,
                        TimeUnit.MILLISECONDS
                    );
            assertNotNull("Resulted event must be published", receivedMessage);

            String receivedPayload = (String) receivedMessage.getPayload();

            OrderCancelled outputEvent = objectMapper.readValue(
                receivedPayload,
                OrderCancelled.class
            );

            LOGGER.info("Response received: {}", outputEvent);

            assertEquals(
                outputEvent.getCancellationReason(),
                "Customer requested cancellation"
            );
            assertEquals(outputEvent.getCancelledAt(), "2024-03-20T00:00:00Z");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            assertTrue(e.getMessage(), false);
        }
    }
}
