package LLD.LLDQuestions.FoodDeliveryApp.models;

public class User {
    private String name;
    private int userId;
    private static int userIdCnt = 0;
    private String userAddress;
    private Cart cart;

    public User(){
        this.userId = ++userIdCnt;
        this.cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Cart getCart() {
        return this.cart;
    }

}
