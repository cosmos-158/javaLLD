package LLD.LLDQuestions.FoodDeliveryApp.strategies;

public class PayCard implements Payment {
    private String cardNumber;

    public PayCard(String card) {
        this.cardNumber = card;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs" + amount + " using Credit Card (" + cardNumber + ")");
    }
}

