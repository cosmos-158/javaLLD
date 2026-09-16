package LLD.LLDQuestions.FoodDeliveryApp;

import LLD.LLDQuestions.FoodDeliveryApp.models.Order;
import LLD.LLDQuestions.FoodDeliveryApp.models.Restaurant;
import LLD.LLDQuestions.FoodDeliveryApp.models.User;
import LLD.LLDQuestions.FoodDeliveryApp.strategies.PayCard;

import java.util.List;

public class MainClass {
    public static void main(String[] args){
        OrchestratorClass foodApp = new OrchestratorClass();
        User user = new User();
        user.setName("Inder Kumar");
        user.setUserAddress("Delhi");
        System.out.println("User: "+ user.getName()+ " is active from" + user.getUserAddress());

        List<Restaurant> restaurantsList = foodApp.searchRestaurant(user.getUserAddress());

        if(restaurantsList.isEmpty()){
            System.out.println("No Restaurants found in "+ user.getUserAddress());
            return;
        }

        System.out.println("Found Restaurants:");
        for (Restaurant restaurant : restaurantsList) {
            System.out.println(" - " + restaurant.getName());
        }

        foodApp.selectRestaurant(user, restaurantsList.get(0));
        System.out.println("Selected restaurant: " + restaurantsList.get(0).getName());

        foodApp.addToCart(user, "P1");
        foodApp.addToCart(user, "P2");

        foodApp.printUserCart(user);

        Order order = foodApp.NowOrder(user,"Delivery", new PayCard("123-456-789"));
        foodApp.payForOrder(order);

    }

}
