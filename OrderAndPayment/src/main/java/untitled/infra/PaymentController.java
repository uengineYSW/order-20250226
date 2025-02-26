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
// @RequestMapping(value="/payments")
@Transactional
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @RequestMapping(
        value = "/payments",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Payment processPayment(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ProcessPaymentCommand processPaymentCommand
    ) throws Exception {
        System.out.println("##### /payment/processPayment  called #####");
        Payment payment = new Payment();
        payment.processPayment(processPaymentCommand);
        paymentRepository.save(payment);
        return payment;
    }

    @RequestMapping(
        value = "/payments/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Payment cancelPayment(
        @PathVariable(value = "id") String id,
        @RequestBody CancelPaymentCommand cancelPaymentCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /payment/cancelPayment  called #####");
        Optional<Payment> optionalPayment = paymentRepository.findById(id);

        optionalPayment.orElseThrow(() -> new Exception("No Entity Found"));
        Payment payment = optionalPayment.get();
        payment.cancelPayment(cancelPaymentCommand);

        paymentRepository.save(payment);
        return payment;
    }
}
//>>> Clean Arch / Inbound Adaptor
