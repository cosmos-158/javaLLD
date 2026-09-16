package LLD.LLDQuestions.FoodDeliveryApp.services;

import LLD.LLDQuestions.FoodDeliveryApp.models.MenuItem;
import LLD.LLDQuestions.FoodDeliveryApp.models.Order;

import java.util.List;

public class Notification {
    public static void notify(Order order) {
        System.out.println("\nNotification: New " + order.getType() + " order placed!");
        System.out.println("---------------------------------------------");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getUser().getName());
        System.out.println("Restaurant: " + order.getRestaurant().getName());
        System.out.println("Items Ordered:");

        List<MenuItem> items = order.getMenuItemList();
        for (MenuItem item : items) {
            System.out.println("   - " + item.getName() + " (Rs" + item.getPrice() + ")");
        }

        System.out.println("Total: Rs" + order.getTotal());
        System.out.println("Scheduled For: " + order.getScheduled());
        System.out.println("Payment: Done");
        System.out.println("---------------------------------------------");
    }
}
