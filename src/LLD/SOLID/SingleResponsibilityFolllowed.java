package LLD.SOLID;

import java.util.ArrayList;

// A class should handle only one responsibility

class Products{
    String name;
    int price;

    public Products(String name, int price){
        this.name = name;
        this.price = price;
    }
}

class Cart{
    ArrayList<Products> p = new ArrayList<>();

    public ArrayList<Products> getProducts() {
        return p;
    }

    public void addProduct(Products pr) {
        this.p.add(pr);
        System.out.println("Added "+pr.name +" to Cart");
    }

    public int totalPrice(){
        int total = 0;
        for(Products pr : p){
            total+=pr.price;
        }
        return total;
    }

}

class SaveToDB{
    Cart c;

    public SaveToDB(Cart c){
        this.c = c;
        System.out.println("Inside save to DB");
    }

    public void save(){
        System.out.println("Saving cart to DB");
    }
}

class PrintCart{
    Cart c;
    public PrintCart(Cart c){
        this.c = c;
        System.out.println("Inside Print Cart");
    }

    public void print(){
        for(Products p: c.getProducts()){
            System.out.println(p.name+" costs "+p.price+" Rs");
        }
        System.out.println("Total Price : " +c.totalPrice()+" Rs");
    }
}

public class SingleResponsibilityFolllowed {
    public static void main(String[] args){
        Products p1 = new Products("Shirt", 1100);
        Products p2 = new Products("Pant", 1200);
        Products p3 = new Products("T-Shirt", 800);

        Cart cart = new Cart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);
        System.out.println();
        SaveToDB sb = new SaveToDB(cart);
        sb.save();
        System.out.println();
        PrintCart pc = new PrintCart(cart);
        pc.print();
    }
}
