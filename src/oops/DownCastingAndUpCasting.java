package oops;

import com.sun.source.tree.ParenthesizedTree;

class Parent{
    public void show1(){
        System.out.println("In Parent show");
    }
}

class Child extends Parent {
    public void show2(){
        System.out.println("In Child show");
    }
}

public class DownCastingAndUpCasting {
    public static void main(String[] args){
        Parent obj1 = new Parent();
        obj1.show1();

        // upcasting
        Parent obj2 = (Parent) new Child();
        obj2.show1();


        //downcasting
        float val= 4.5f;
        int num = (int) val;
        System.out.println(num);
        
        // class level eg of downcasting
        //obj1.show2() -> error
        Child obj = (Child) obj2;
        obj.show2();
    }
}
