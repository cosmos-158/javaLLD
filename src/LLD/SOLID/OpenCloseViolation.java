package LLD.SOLID;

/*
    Using same example as in SingleResponsibilityFollowed i.e. This time let's suppose we have different databases to
    save. So the first thought will be to add these function in saveToDB class and hence this class will be modified.
    This is violation of Open-Close Principle i.e. class should be open for extension but closed for modification.
    Open-Close Principle is achieved using Abstraction, Inheritance and Polymorphism.

    For violation of OCP consider e.g. or SingleResponsibilityFollowed and just add new methods in saveToDB class.
    i.e saveToMongoDB(), saveToSQLDB(), etc
 */

import java.util.ArrayList;

class Comics{
    String name;
    int price;

    public Comics(String name, int price){
        this.name = name;
        this.price = price;
    }
}

class ComicsCart{
    ArrayList<Comics> p = new ArrayList<>();

    public ArrayList<Comics> getProducts() {
        return p;
    }

    public void addProduct(Comics pr) {
        this.p.add(pr);
        System.out.println("Added "+pr.name +" to Cart");
    }

    public int totalPrice(){
        int total = 0;
        for(Comics pr : p){
            total+=pr.price;
        }
        return total;
    }

}

class SaveDB{
    ComicsCart c;

    public SaveDB(ComicsCart c){
        this.c = c;
        System.out.println("Inside save to DB");
    }

    public void saveSQL(){
        System.out.println("Saving cart to SQL DB");
    }
    public void saveMongo(){
        System.out.println("Saving cart to Mongo DB");
    }
    public void saveFile(){
        System.out.println("Saving cart to File");
    }
}

class PrintComicsCart{
    ComicsCart c;
    public PrintComicsCart(ComicsCart c){
        this.c = c;
        System.out.println("Inside Print Cart");
    }

    public void print(){
        for(Comics p: c.getProducts()){
            System.out.println(p.name+" costs "+p.price+" Rs");
        }
        System.out.println("Total Price:" +c.totalPrice()+" Rs");
    }
}

public class OpenCloseViolation {
    public static void main(String[] args){
        Comics c1 = new Comics("Manga", 12100);
        Comics c2 = new Comics("Langa", 12400);
        Comics c3 = new Comics("Tanga", 8040);

        ComicsCart cart = new ComicsCart();
        cart.addProduct(c1);
        cart.addProduct(c2);
        cart.addProduct(c3);
        System.out.println();
        SaveDB sb = new SaveDB(cart);
        sb.saveSQL();
        sb.saveMongo();
        sb.saveFile();
        System.out.println();
        PrintComicsCart pc = new PrintComicsCart(cart);
        pc.print();
    }
}
