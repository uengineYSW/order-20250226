package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRepository
    extends PagingAndSortingRepository<Order, String> {
    @Query(
        value = "select order " +
        "from Order order " +
        "where(:orderStatus is null or order.orderStatus = :orderStatus) and (:totalAmount is null or order.totalAmount = :totalAmount)"
    )
    List<Order> orderSummary(
        OrderStatus orderStatus,
        Double totalAmount,
        Pageable pageable
    );

    @Query(
        value = "select order " +
        "from Order order " +
        "where(:customerId is null or order.customerId like %:customerId%) and (:orderStatus is null or order.orderStatus = :orderStatus) and (:totalAmount is null or order.totalAmount = :totalAmount)"
    )
    Order orderDetails(
        String customerId,
        OrderStatus orderStatus,
        Double totalAmount
    );
}
