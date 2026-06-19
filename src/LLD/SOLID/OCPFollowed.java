package LLD.SOLID;

import java.util.ArrayList;

class Comic{
    String name;
    int price;

    public Comic(String name, int price){
        this.name = name;
        this.price = price;
    }
}

class ComicCart{
    ArrayList<Comic> p = new ArrayList<>();

    public ArrayList<Comic> getProducts() {
        return p;
    }

    public void addProduct(Comic pr) {
        this.p.add(pr);
        System.out.println("Added "+pr.name +" to Cart");
    }

    public int totalPrice(){
        int total = 0;
        for(Comic pr : p){
            total+=pr.price;
        }
        return total;
    }

}

interface SaveToDatabase{
    void save(ComicCart c);
}

class saveToSQL implements SaveToDatabase{
    ComicCart c;
    public saveToSQL(){
        System.out.println("Saving to SQL....");
    }
    public void save(ComicCart c){
        this.c = c;
        System.out.println("Saved details for SQL Database");
    }
}

class saveToMongo implements SaveToDatabase{
    ComicCart c;
    public saveToMongo(){
        System.out.println("Saving to Mongo....");
    }
    public void save(ComicCart c){
        this.c = c;
        System.out.println("Saved details for Mongo Database");
    }
}

class saveToFile implements SaveToDatabase{
    ComicCart c;
    public saveToFile(){
        System.out.println("Saving to File....");
    }
    public void save(ComicCart c){
        this.c = c;
        System.out.println("Saved details for File");
    }
}

class PrintComicCart{
    ComicCart c;
    public PrintComicCart(ComicCart c){
        this.c = c;
        System.out.println("Inside Print Cart");
    }

    public void print(){
        for(Comic p: c.getProducts()){
            System.out.println(p.name+" costs "+p.price+" Rs");
        }
        System.out.println("Total Price : " +c.totalPrice()+" Rs");
    }
}

public class OCPFollowed {
    public static void main(String[] args){
        Comic c1 = new Comic("Shaktiman", 1999);
        Comic c2 = new Comic("Batman", 1998);
        Comic c3 = new Comic("Superman", 2999);

        ComicCart cc = new ComicCart();
        cc.addProduct(c1);
        cc.addProduct(c2);
        cc.addProduct(c3);

        System.out.println();

        PrintComicCart pc = new PrintComicCart(cc);
        pc.print();

        System.out.println();

        SaveToDatabase sbSQL = new saveToSQL();
        sbSQL.save(cc);
        System.out.println();
        SaveToDatabase sbFile = new saveToFile();
        sbFile.save(cc);
        System.out.println();
        SaveToDatabase sbMongo = new saveToMongo();
        sbMongo.save(cc);
        System.out.println();
    }
}
