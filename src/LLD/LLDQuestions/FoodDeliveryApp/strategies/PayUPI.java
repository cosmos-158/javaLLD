package LLD.LLDQuestions.FoodDeliveryApp.strategies;

public class PayUPI implements Payment{
    private String mobile;

    public PayUPI(String mob) {
        this.mobile = mob;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs" + amount + " using UPI (" + mobile + ")");
    }
}
