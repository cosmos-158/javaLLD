package oops;

class OuterClass{
    public void show(){
        System.out.println("In Class A");
    }

    // this can be made static but not the outer class
    class InClass{
        public void show(){
            System.out.println("In Inner Class B");
        }
    }
}

public class InnerClass {
    public static void main(String[] args){
        OuterClass obj = new OuterClass();
        obj.show();

        OuterClass.InClass obj1 = obj.new InClass();
        obj1.show();
    }
}
