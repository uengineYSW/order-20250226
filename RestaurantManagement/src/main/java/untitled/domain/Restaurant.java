package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.RestaurantManagementApplication;

@Entity
@Table(name = "Restaurant_table")
@Data
//<<< DDD / Aggregate Root
public class Restaurant {

    @Id
    private String restaurantId;

    private String name;

    public static RestaurantRepository repository() {
        RestaurantRepository restaurantRepository = RestaurantManagementApplication.applicationContext.getBean(
            RestaurantRepository.class
        );
        return restaurantRepository;
    }

    //<<< Clean Arch / Port Method
    public void confirmOrder(ConfirmOrderCommand confirmOrderCommand) {
        //implement business logic here:

        OrderConfirmed orderConfirmed = new OrderConfirmed(this);
        orderConfirmed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void addMenuItem(AddMenuItemCommand addMenuItemCommand) {
        //implement business logic here:

        MenuItemAdded menuItemAdded = new MenuItemAdded(this);
        menuItemAdded.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
