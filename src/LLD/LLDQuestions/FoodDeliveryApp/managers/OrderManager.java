package LLD.LLDQuestions.FoodDeliveryApp.managers;

import LLD.LLDQuestions.FoodDeliveryApp.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orderList = new ArrayList<>();
    public static OrderManager orderManager = null;

    private OrderManager(){}

    public static OrderManager getInstance(){
        if(orderManager==null)
            orderManager = new OrderManager();
        return orderManager;
    }

    public void addOrders(Order order){
        this.orderList.add(order);
    }

    public void showOrder(){
        System.out.println("\n--- All Orders ---");
        for(Order order : orderList){
            System.out.println(order.getType() + " order for "+ order.getUser().getName()
                             + " | Total: "+ order.getTotal()+"Rs"
                             + " | At: " + order.getScheduled());
        }
    }

}
