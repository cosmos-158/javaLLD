package LLD.LLDQuestions.FoodDeliveryApp.models;

public class PickupOrder extends Order {
    private String restaurantAddress;

    public String getType(){
        return "pickupOrder";
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

}
