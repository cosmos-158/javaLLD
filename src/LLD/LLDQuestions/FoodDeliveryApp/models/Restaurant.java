package LLD.LLDQuestions.FoodDeliveryApp.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int restIdCnt = 0;
    private int restId;
    private String location;
    private List<MenuItem> menuItemList = new ArrayList<>();
    private String name;

    public Restaurant(String location, String name){
        this.location = location;
        this.restId = ++restIdCnt;
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMenueItems(MenuItem menuItem){
        this.menuItemList.add(menuItem);
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

}
