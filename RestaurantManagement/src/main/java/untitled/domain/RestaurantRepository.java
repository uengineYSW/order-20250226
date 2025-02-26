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
    collectionResourceRel = "restaurants",
    path = "restaurants"
)
public interface RestaurantRepository
    extends PagingAndSortingRepository<Restaurant, String> {
    @Query(
        value = "select restaurant " +
        "from Restaurant restaurant " +
        "where(:orderStatus is null or restaurant.orderStatus = :orderStatus)"
    )
    List<Restaurant> newOrders(
        RestaurantOrderStatus orderStatus,
        Pageable pageable
    );
}
