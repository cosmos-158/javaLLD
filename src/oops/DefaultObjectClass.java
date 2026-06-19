package oops;

class Cosmos{
    private int galaxy;
    public Cosmos(int n1){
        this.galaxy = n1;
    }
}

class Universe{
    public String toString(){
        return "Hi from somwehere";
    }
}

public class DefaultObjectClass {
    public static void main(String[] args){
        Cosmos obj = new Cosmos(1);
        System.out.println(obj); // this is exactly same as System.out.println(obj.toString())
        System.out.println(obj.toString());

        //we can override this default toString() function of Object class
        Universe obj1 = new Universe();
        System.out.println(obj1);

        Cosmos obj2 = new Cosmos(1);
        boolean res = obj==obj2;
        System.out.println(res);

        boolean res1 = obj.equals(obj2);
        System.out.println(res1);

    }
}
