package LLD.SOLID;

/*
    Let's say we have Product class and ShoppingCart class and there is "has a" relation between ShoppingCart and Product.
    Here Shopping cart handles total price calculation, save to db and generating invoice. This violates Single Resp Pri
    as shopping cart is handling multiple things.
*/

import java.util.ArrayList;

class Product{
    String name;
    int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart{
    ArrayList<Product> p = new ArrayList<>();

    public void getProducts() {
        for(Product pr : p){
            System.out.println(pr.name+" costs "+pr.price+" Rs");
        }
    }

    public void addProduct(Product pr) {
        this.p.add(pr);
    }

    public int totalPrice(){
        int total = 0;
        for(Product pr : p){
            total+=pr.price;
        }
        return total;
    }

    public void saveToDB(){
        System.out.println("Saved to DB");
    }
}

public class SingleResponsibilityViolation {
    public static void main(String[] args){
        Product p1 = new Product("Shirt", 1100);
        Product p2 = new Product("Pant", 1200);
        Product p3 = new Product("T-Shirt", 800);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);

        cart.getProducts();
        cart.saveToDB();
    }

}
