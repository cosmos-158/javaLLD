package LLD.LLDQuestions.FoodDeliveryApp.factories;

import LLD.LLDQuestions.FoodDeliveryApp.models.*;
import LLD.LLDQuestions.FoodDeliveryApp.strategies.Payment;

import java.util.List;

public class ScheduledOrderFactory implements OrderFactory{
    private String scheduleTime;

    public ScheduledOrderFactory(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    @Override
    public Order createOrder(Cart cart, User user, List<MenuItem> menuItem, Restaurant restaurant,
                             Payment paymentStrategy, double totalCost, String orderType){
        Order order = null;

        if (orderType.equals("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getUserAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setMenuItemList(menuItem);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(this.scheduleTime);
        order.setTotal(totalCost);
        return order;
    }
}
