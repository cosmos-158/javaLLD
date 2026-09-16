package LLD.LLDQuestions.FoodDeliveryApp.models;

public class MenuItem {
    private String name;
    private double price;
    private String itemCode;

    public MenuItem(String code, String name, double price){
        this.name = name;
        this.price = price;
        this.itemCode = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemCode() {
        return this.itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
