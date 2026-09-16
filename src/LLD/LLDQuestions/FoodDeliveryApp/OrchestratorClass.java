package LLD.LLDQuestions.FoodDeliveryApp;

import LLD.LLDQuestions.FoodDeliveryApp.factories.NowOrderFactory;
import LLD.LLDQuestions.FoodDeliveryApp.factories.OrderFactory;
import LLD.LLDQuestions.FoodDeliveryApp.factories.ScheduledOrderFactory;
import LLD.LLDQuestions.FoodDeliveryApp.managers.OrderManager;
import LLD.LLDQuestions.FoodDeliveryApp.managers.RestaurantManager;
import LLD.LLDQuestions.FoodDeliveryApp.models.*;
import LLD.LLDQuestions.FoodDeliveryApp.services.Notification;
import LLD.LLDQuestions.FoodDeliveryApp.strategies.Payment;

import java.util.List;

public class OrchestratorClass {
    public OrchestratorClass(){
        initializeRestaurants();
    }

    public void initializeRestaurants(){
        Restaurant restaurant1 = new Restaurant("Delhi", "Bikaner");
        restaurant1.addMenueItems(new MenuItem("P1","Chole Bhature", 120));
        restaurant1.addMenueItems(new MenuItem("P2","Samose", 20));
        restaurant1.addMenueItems(new MenuItem("P3","Panu Puri", 80));

        Restaurant restaurant2 = new Restaurant("Pune", "Falahaar");
        restaurant2.addMenueItems(new MenuItem("P4","Samosa Sandwich", 320));
        restaurant2.addMenueItems(new MenuItem("P5","Pahadi Grilled Sandwich", 180));
        restaurant2.addMenueItems(new MenuItem("P6","Mango Milkshake", 120));

        Restaurant restaurant3 = new Restaurant("Vadodara", "Haldiram");
        restaurant3.addMenueItems(new MenuItem("P7","Raj Kachori", 120));
        restaurant3.addMenueItems(new MenuItem("P8","Samosa Chat", 200));
        restaurant3.addMenueItems(new MenuItem("P9","Rasmalai", 60));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);
    }

    public List<Restaurant> searchRestaurant(String location){
        return RestaurantManager.getInstance().getRestaurantByLocation(location);
    }

    public void selectRestaurant(User user, Restaurant restaurant){
        Cart cart = user.getCart();
        cart.setRestaurant(restaurant);
    }

    public void addToCart(User user, String itemCode){
        Restaurant restaurant = user.getCart().getRestaurant();
        if(restaurant==null){
            System.out.println("Please select restaurant first");
        } else {
            for(MenuItem menuItem : restaurant.getMenuItemList()){
                if(menuItem.getItemCode().equals(itemCode))
                    user.getCart().addToCart(menuItem);
            }
        }
    }

    public Order NowOrder(User user, String orderType, Payment paymentStrategy){
        return checkout(user, orderType, paymentStrategy, new NowOrderFactory());
    }

    public Order ScheduledOrder(User user, String orderType, Payment paymentStrategy, String scheduleTime){
        return checkout(user, orderType, paymentStrategy, new ScheduledOrderFactory(scheduleTime));
    }

    public Order checkout(User user, String orderType, Payment paymentStrategy, OrderFactory orderFactory){
        if(user.getCart().isEmpty())
            return null;
        Cart userCart = user.getCart();
        Restaurant orderedRestaurant = userCart.getRestaurant();
        List<MenuItem> itemsOrdered = userCart.getCartItems();
        double totalCost = userCart.getCartTotal();
//        (Cart cart, User user, List<MenuItem> menuItem, Restaurant restaurant,
//                Payment paymentStrategy, double totalCost, String orderType);
        Order order = orderFactory.createOrder(userCart, user, itemsOrdered, orderedRestaurant, paymentStrategy, totalCost, orderType);
        OrderManager orderManager = OrderManager.getInstance();
        orderManager.addOrders(order);
        return order;
    }

    public void payForOrder(Order order){
        boolean isPayment = order.processPayment();
        if(isPayment){
            Notification.notify(order);
            order.getUser().getCart().clear();
        }
    }

    public void printUserCart(User user){
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuItem item : user.getCart().getCartItems()) {
            System.out.println(item.getItemCode() + " : " + item.getName() + " : Rs" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : Rs" + user.getCart().getCartTotal());
    }

}
