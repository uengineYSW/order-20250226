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
public class DeliverOrderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        DeliverOrderTest.class
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
    public DeliveryRepository repository;

    @Test
    @SuppressWarnings("unchecked")
    public void test0() {
        //given:
        Delivery entity = new Delivery();

        entity.setId(101L);
        entity.setDeliveryStatus("In Transit");
        entity.setAssignedDeliverer("deliverer1");
        entity.setPickupTime("2024-03-20T09:00:00Z");
        entity.setDeliveryTime(null);
        entity.setIssueReport(null);

        repository.save(entity);

        //when:
        try {
            DeliverOrderCommand command = new DeliverOrderCommand();

            command.setId(101L);
            command.setDeliveryTime("2024-03-20T11:00:00Z");

            entity.deliverOrder(command);

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

            DeliveryCompleted outputEvent = objectMapper.readValue(
                receivedPayload,
                DeliveryCompleted.class
            );

            LOGGER.info("Response received: {}", outputEvent);

            assertEquals(outputEvent.getId(), 101L);
            assertEquals(outputEvent.getDeliveryTime(), "2024-03-20T11:00:00Z");
            assertEquals(outputEvent.getDeliveryStatus(), "Delivered");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            assertTrue(e.getMessage(), false);
        }
    }
}
