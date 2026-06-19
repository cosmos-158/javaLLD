package LLD.DesignPatterns.FactoryDesignPattern;

import java.util.Scanner;

// Product
interface Sandwich{
    void prepare();
}

class WhiteBreadBasicSandwich implements Sandwich{
    public void prepare(){
        System.out.println("Preparing White Bread Basic Sandwich...");
    }
}

class WhiteBreadPremiumSandwich implements Sandwich{
    public void prepare(){
        System.out.println("Preparing White Bread Premium Sandwich...");
    }
}

class BrownBreadBasicSandwich implements Sandwich{
    public void prepare(){
        System.out.println("Preparing Brown Bread Basic Sandwich...");
    }
}

class BrownBreadPremiumSandwich implements Sandwich{
    public void prepare(){
        System.out.println("Preparing Brown Bread Premium Sandwich...");
    }
}

// Factory
interface SandwichFactory{
    Sandwich getSandwich();
}

class WhiteBreadSandwichFactory implements SandwichFactory{
    private final String type;
    public WhiteBreadSandwichFactory(String type){
        this.type = type;
    }
    public Sandwich getSandwich(){
        if(type.equals("basic")){
            return new WhiteBreadBasicSandwich();
        } else if(type.equals("premium")){
            return new WhiteBreadPremiumSandwich();
        } else
            return null;
    }
}

class BrownBreadSandwichFactory implements SandwichFactory{
    private final String type;
    public BrownBreadSandwichFactory(String type){
        this.type = type;
    }
    public Sandwich getSandwich(){
        if(type.equals("basic")){
            return new BrownBreadBasicSandwich();
        } else if(type.equals("premium")){
            return new BrownBreadPremiumSandwich();
        } else
            return null;
    }
}

public class FactoryMethod {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Which Sandwich you want premium or basic : ");
        String type = sc.next();

        System.out.print("White or Brown: ");
        String factory = sc.next();

        SandwichFactory fact;

        if(factory.equals("white"))
            fact = new WhiteBreadSandwichFactory(type);
        else
            fact = new BrownBreadSandwichFactory(type);

        Sandwich sandwich = fact.getSandwich();
        sandwich.prepare();

    }
}
