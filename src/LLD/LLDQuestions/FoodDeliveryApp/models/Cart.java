package LLD.LLDQuestions.FoodDeliveryApp.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> menuItemList = new ArrayList<>();
    private Restaurant restaurant;
    double total = 0.0;

    public void Cart(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    public void addToCart(MenuItem menuItem){
        menuItemList.add(menuItem);
    }

    public double getCartTotal(){
        double res = 0.0;
        for(MenuItem menuItem: menuItemList){
            res+=menuItem.getPrice();
        }
        return res;
    }

    public boolean isEmpty(){
        return restaurant==null||menuItemList.isEmpty();
    }

    public void clear(){
        menuItemList.clear();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuItem> getCartItems(){
        return menuItemList;
    }
}
