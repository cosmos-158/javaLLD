package LLD.LLDQuestions.FoodDeliveryApp.models;

import LLD.LLDQuestions.FoodDeliveryApp.strategies.Payment;

import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    private User user;
    private List<MenuItem> menuItemList = new ArrayList<>();
    private Restaurant restaurant;
    private int orderId;
    private static int orderIdCnt = 0;
    private Payment paymentStrategy;
    private String scheduled;
    private double total = 0.0;

    public Order(){
        this.orderId = ++orderIdCnt;
    }

    public abstract String getType();

    public boolean processPayment(){
        if (paymentStrategy != null) {
            paymentStrategy.pay(total);
            return true;
        } else {
            System.out.println("Please choose a payment mode first");
            return false;
        }
    }

    // Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Payment getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(Payment paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
