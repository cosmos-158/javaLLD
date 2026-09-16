package LLD.LLDQuestions.FoodDeliveryApp.factories;

import LLD.LLDQuestions.FoodDeliveryApp.models.*;
import LLD.LLDQuestions.FoodDeliveryApp.strategies.Payment;
import LLD.LLDQuestions.FoodDeliveryApp.utils.TimeUtils;

import java.util.List;

public class NowOrderFactory implements OrderFactory{
    @Override
    public Order createOrder(Cart cart, User user, List<MenuItem> menuItem, Restaurant restaurant,
                 Payment paymentStrategy, double totalCost, String orderType){
        Order order = null;
        if(orderType.toLowerCase().equals("delivery")){
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getUserAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }
        order.setRestaurant(restaurant);
        order.setUser(user);
        order.setMenuItemList(menuItem);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(TimeUtils.getCurrentTime());
        order.setTotal(totalCost);
        return order;
    }
}
