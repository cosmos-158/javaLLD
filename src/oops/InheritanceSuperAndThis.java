package oops;
//import java.lang.* -> this is there by default in every java file
// Note: * in the above import means all the files and not the folders inside lang

//every constructor in java has a method i.e. super() even if we don't specify it.
// every class in java extends Object class


class AClass{
    public AClass(){
        // super() -> by default this is there in every constructor even if we don't mention this explicitly.
        // This means that call the constructor of super class

        // here since AClass don't have any parent class hence it will call constructor of Object class as every class
        // in java extends Object Class
        System.out.println("Constructor of AClass");
    }

    public AClass(int num){
        // super() -> default
        System.out.println("Constructor parameterized constructor of AClass");
    }

}

class BClass extends AClass{
    public BClass(){
        // super() -> by default this is there in every constructor even if we don't mention this explicitly.
        // This means that call the constructor of super class
        System.out.println("Constructor of B");
    }

    public BClass(int num){
        // super() -> default
        // super(num); //comment this and uncomment the above one to see the difference
        // when we pass num then it calls the parameterized constructor of Aclass and if we don't pass anything then it
        // calls the default constructor of AClass

        // this() -> this calls the default constructor of same class. So here it will call BClass() constructor
        System.out.println("Calling parameterized constructor of BClass");
    }

}

public class InheritanceSuperAndThis {
    public static void main(String[] args){
        // by default child class calls its constructor and constructor of parent class as well
        BClass obj = new BClass();
        System.out.println("------------------------");
        BClass obj2 = new BClass(5);
    }
}
