package LLD.DesignPatterns.FactoryDesignPattern;

import java.util.Scanner;

interface Burger{
    void prepare();
}

class BasicB implements Burger{
    public void prepare(){
        System.out.println("Preparing Basic Burger...");
        System.out.println("Ingredients: Bun, Patty, Cheese");
    }
}

class StandardB implements Burger{
    public void prepare(){
        System.out.println("Preparing Standard Burger...");
        System.out.println("Ingredients: Bun, Patty, Cheese, Sauce, Salads");
    }
}

class PremiumB implements Burger{
    public void prepare(){
        System.out.println("Preparing Premium Burger...");
        System.out.println("Ingredients: Premium Bun, Double Patty, Cheese, Sauce, Salads, Mayonnaise + Drink of your choice");
    }
}

class BurgerFactory{
    private final String type;
    public BurgerFactory(String type){
        this.type = type;
    }

    public Burger prepareBurger(){
        if(type.equals("Basic"))
            return new BasicB();
        else if(type.equals("Standard"))
            return new StandardB();
        else if(type.equals("Premium"))
            return new PremiumB();
        else {
            System.out.println("We don't have this in stock");
            return null;
        }
    }
}

public class SimpleFactory {
    public static void main(String[] args){
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Which Burger you want: ");
            String type = sc.next();


            BurgerFactory factory = new BurgerFactory(type);
            Burger burger = factory.prepareBurger();
            if(burger==null)
                break;
            burger.prepare();
        }
    }
}
