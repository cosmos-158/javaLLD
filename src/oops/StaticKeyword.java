package oops;

class Creature{
    int name;
    String age;
    static String species; // class level variable, referred using class name

    // static blocks are used to set value of static variables, these should not be set in
    // constructors rather they should be set in static block. It is called first i.e. before constructor
    // Everytime we create object two steps happens:
    //  1. Class loads first
    //  2. Objects are instantiated
    static{
        species = "Sapiens";
        System.out.println("Called static block");
    }

    public Creature(String age, int name){
        this.name = name;
        this.age = age;
        System.out.println("Constructor called");
    }

    public void show(){
        System.out.println("Name : " + this.name +"\nAge : " + this.age);
        System.out.println();
    }

    public static void displaySpecies(Creature obj){
        System.out.println("Name : " + obj.name +"\nAge : " + obj.age +"\nSpecies : " + species);
        System.out.println();
    }

}

public class StaticKeyword {
    public static void main(String[] args) throws ClassNotFoundException {

        // If we don't create object then class won't get loaded. Java has special class called Class which is to load
        // classes without creating objects.
        //Class.forName("oops.Creature");
        Creature obj1 = new Creature("Ashish", 25);
        Creature obj2 = new Creature("Ashu", 26);

        obj1.show();
        obj2.show();

        // static methods are to be called with class name and if we want to work with
        // different objects then pass object in the static methods
        Creature.displaySpecies(obj1);
        Creature.displaySpecies(obj2);

    }

}
