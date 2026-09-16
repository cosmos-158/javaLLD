package LLD.LLDQuestions.FoodDeliveryApp.factories;

import LLD.LLDQuestions.FoodDeliveryApp.models.*;
import LLD.LLDQuestions.FoodDeliveryApp.strategies.Payment;

import java.util.List;

public interface OrderFactory {
    Order createOrder(Cart cart, User user, List<MenuItem> menuItem, Restaurant restaurant,
                      Payment paymentStrategy, double totalCost, String orderType);
}
