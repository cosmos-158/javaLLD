package oops;

abstract class AbsClass {
    abstract public void show();
    public int get(){
        return -1;
    }
}

class AbsExt extends AbsClass {
    public void show() {
        System.out.println("Abstract class implementation in child class");
    }
}

interface Inter {
    // here by default every method is public and abstract

    // the above two variable declaration will throw error
    // by default all the variables in interface are final and static

    //    int age; -> incorrect
    //    int age = 24;
    int age = 24;
    void showInterface();
    int getInterface();
}

class InterImp implements Inter {
    public void showInterface() {
        System.out.println("Hi From Interface Implementation");
    }

    public int getInterface(){
        return -2;
    }
}

// we can use inheritance in interface same as class
    // class - class -> extends
    // class - interface -> implements
    // interface - interface -> extends

public class AbstractClassAndInterfaces {
    public static void main(String[] args){
        AbsClass ac = new AbsExt();
        ac.show();
        System.out.println(ac.get());

        InterImp obj = new InterImp();
        obj.showInterface();
        System.out.println(obj.getInterface());
        System.out.println(InterImp.age);

    }
}
