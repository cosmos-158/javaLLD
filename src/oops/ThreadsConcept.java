package oops;

/* These two are normal classes */
class T1{
    public void show(){
        for(int i=0;i<10;i++)
            System.out.println("Hi from T1");
    }
}

class T2{
    public void show(){
        for(int i=0;i<10;i++)
            System.out.println("Hi from T2");
    }
}

/* If we want to make class as thread then simple extend Thread class
   In every thread you need to have run method which gets triggered when object.start() is invoked.
   This approach of creating Thread using Thread class is not recommended rather we prefer using Runnable interface.
*/
class Th1 extends Thread{
    public void run(){
        for(int i=0;i<10;i++) {
            System.out.println("Hi..");
            // this try catch is optional. To get one Hi and one Hello we are putting this.
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Th2 extends Thread{
    public void run(){
        for(int i=0;i<10;i++) {
            System.out.println("Hello..");
            // this try catch is optional.
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadsConcept {
    public static void main(String[] args){
        T1 obj1 = new T1();
        T2 obj2 = new T2();
//        obj1.show();
//        obj2.show();

        Th1 ob1 = new Th1();
        Th2 ob2 = new Th2();

        System.out.println(ob1.getPriority()); // default priority is 5
        // 10 is highest priority. We can only suggest scheduler. Behind the scenes scheduler will decide itself
        ob2.setPriority(10); // ob2.setPriority(Thread.MAX_PRIORITY); both are same

        ob1.start(); // we can add sleep here as well.
        ob2.start();
    }
}
