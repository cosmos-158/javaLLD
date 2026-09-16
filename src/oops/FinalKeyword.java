package oops;
// final -> can be used with variable, method, class

// adding final before class stops its inheritance
final class FinalClass{
    public void show(){
        System.out.println("In FinalClass show()");
    }

    public int add(int n1, int n2){
        return n1+n2;
    }

}

// this gives error since FinalClass class is final
// class FinalClassChild extends FinalClass{
//
//}

class PrintName{
    public void show(){
        System.out.println("In PrintName show()");
    }

    // this method cannot be overridden
    public final void printName(String name){
        System.out.println("Hello " + name);
    }

}

class GreetPerson extends PrintName{
    public void showWithFeatures(){
        System.out.println("In PrintName showWithFeatures()");
    }

    // this gives error as this method cannot be overridden since it is declared with final keyword in base class
//    public void printName(String name){
//        System.out.println("Hello " + name + " from printName of Child class");
//    }
}

public class FinalKeyword {
    public static void main(String[] args){
        final int num = 8; // this cannot be changed further
        System.out.println(num);
//        num = 8; -> will throw error

        GreetPerson gp = new GreetPerson();
        gp.showWithFeatures();
        gp.printName("Ashish");

    }
}
