package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "payments", path = "payments")
public interface PaymentRepository
    extends PagingAndSortingRepository<Payment, String> {
    @Query(
        value = "select payment " +
        "from Payment payment " +
        "where(:amount is null or payment.amount = :amount) and (:paymentStatus is null or payment.paymentStatus = :paymentStatus)"
    )
    List<Payment> paymentSummary(
        Double amount,
        PaymentStatus paymentStatus,
        Pageable pageable
    );

    @Query(
        value = "select payment " +
        "from Payment payment " +
        "where(:amount is null or payment.amount = :amount) and (:paymentStatus is null or payment.paymentStatus = :paymentStatus) and (:completedAt is null or payment.completedAt = :completedAt) and (:cancellationReason is null or payment.cancellationReason like %:cancellationReason%) and (:cancelledAt is null or payment.cancelledAt = :cancelledAt)"
    )
    Payment paymentDetails(
        Double amount,
        PaymentStatus paymentStatus,
        Date completedAt,
        String cancellationReason,
        Date cancelledAt
    );
}
