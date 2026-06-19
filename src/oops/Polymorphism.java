package oops;

// Same reference will have different behavior based on the object it is pointing to
// Compile time Polymorphism -> Method Overloading
// Runtime Polymorphism -> Method Overriding (Dynamic Method Dispatching)

class Animal{
    int legs;
    String eatingHabits;

    public Animal(){
        System.out.println("Constructor of Animal Class");
    }

    public Animal(int legs, String eatingHabits){
        this.legs = legs;
        this.eatingHabits = eatingHabits;
    }

    public void walk(){
        System.out.println("Walks on " + this.legs + " legs");
    }
}

class Dog extends Animal{
    public Dog(){
        System.out.println("Called constructor of Dog");
    }

    public Dog(int legs, String eatingHabits){
        super(legs, eatingHabits);
    }

    public void walk(){
        System.out.println("Walks on " + this.legs + " legs and runs as well");
    }

    public String sound(){
        return "Barks Normally";
    }

    public String sound(String str){
        return "Barks " + str;
    }

    public String sound(String str, String times){
        return "Barks "+str+" "+times;
    }

}

public class Polymorphism {
    public static void main(String[] args){
//        Animal obj = new Animal(4,"Carnivorous");
//        obj.walk();
        Animal obj2 = new Dog(4, "Carnivorous");
        obj2.walk(); // eg of method overriding

        //Method Overloading
        Dog d1 = new Dog(4,"Herbivore");
        System.out.println(d1.sound());
        System.out.println(d1.sound("Loud"));
        System.out.println(d1.sound("Daily", "three times"));


    }
}
