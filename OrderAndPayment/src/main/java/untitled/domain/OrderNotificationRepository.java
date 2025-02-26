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
    collectionResourceRel = "orderNotifications",
    path = "orderNotifications"
)
public interface OrderNotificationRepository
    extends PagingAndSortingRepository<OrderNotification, String> {
    @Query(
        value = "select orderNotification " +
        "from OrderNotification orderNotification " +
        "where(:notificationId is null or orderNotification.notificationId like %:notificationId%) and (:notificationType is null or orderNotification.notificationType like %:notificationType%) and (:notifiedAt is null or orderNotification.notifiedAt = :notifiedAt)"
    )
    List<OrderNotification> orderNotificationSummary(
        String notificationId,
        String notificationType,
        Date notifiedAt,
        Pageable pageable
    );
}
