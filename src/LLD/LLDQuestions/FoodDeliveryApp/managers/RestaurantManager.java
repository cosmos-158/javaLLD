package LLD.LLDQuestions.FoodDeliveryApp.managers;

import LLD.LLDQuestions.FoodDeliveryApp.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    private final List<Restaurant> restaurantList = new ArrayList<>();
    public static RestaurantManager obj = null;

    private RestaurantManager(){}

    public static RestaurantManager getInstance(){
        if(obj==null)
            obj = new RestaurantManager();
        return obj;
    }

    public void addRestaurant(Restaurant restaurant){
        this.restaurantList.add(restaurant);
    }

    public List<Restaurant> getRestaurantByLocation(String location){
        List<Restaurant> result = new ArrayList<>();
        location = location.toLowerCase();
        for(Restaurant restaurant: restaurantList){
            if(restaurant.getLocation().toLowerCase().equals(location)){
                result.add(restaurant);
            }
        }
        return result;
    }

}
