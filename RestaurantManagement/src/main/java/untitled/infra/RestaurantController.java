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
// @RequestMapping(value="/restaurants")
@Transactional
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @RequestMapping(
        value = "/restaurants/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Restaurant confirmOrder(
        @PathVariable(value = "id") String id,
        @RequestBody ConfirmOrderCommand confirmOrderCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /restaurant/confirmOrder  called #####");
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(
            id
        );

        optionalRestaurant.orElseThrow(() -> new Exception("No Entity Found"));
        Restaurant restaurant = optionalRestaurant.get();
        restaurant.confirmOrder(confirmOrderCommand);

        restaurantRepository.save(restaurant);
        return restaurant;
    }

    @RequestMapping(
        value = "/restaurants",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Restaurant addMenuItem(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody AddMenuItemCommand addMenuItemCommand
    ) throws Exception {
        System.out.println("##### /restaurant/addMenuItem  called #####");
        Restaurant restaurant = new Restaurant();
        restaurant.addMenuItem(addMenuItemCommand);
        restaurantRepository.save(restaurant);
        return restaurant;
    }
}
//>>> Clean Arch / Inbound Adaptor
