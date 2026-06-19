package LLD.LLDQuestions.FoodDeliveryApp.models;

public class DeliveryOrder extends Order {
    private String userAddress;

    public String getType(){
        return "delivery";
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
