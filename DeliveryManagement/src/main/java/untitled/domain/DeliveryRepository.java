package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "deliveries",
    path = "deliveries"
)
public interface DeliveryRepository
    extends PagingAndSortingRepository<Delivery, Long> {
    @Query(
        value = "select delivery " +
        "from Delivery delivery " +
        "where(:assignedDeliverer is null or delivery.assignedDeliverer like %:assignedDeliverer%) and (:deliveryStatus is null or delivery.deliveryStatus = :deliveryStatus)"
    )
    List<Delivery> assignedDeliveryOrders(
        String assignedDeliverer,
        DeliveryStatus deliveryStatus,
        Pageable pageable
    );
}
