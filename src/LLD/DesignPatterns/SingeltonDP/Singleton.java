package LLD.DesignPatterns.SingeltonDP;

// A Singleton class in Java is a class that allows only one object to be created during the entire program.

// =========================================
// NOT THREAD SAFE SINGLETON
// =========================================
class SingletonClass{
    private static SingletonClass obj;

    private SingletonClass(){
        System.out.println("Created SingletonClass object by " + Thread.currentThread().getName());
    }

    public static SingletonClass getInstance(){
        if(obj==null) {
            // Artificial Delay
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            obj = new SingletonClass();
        }
        return obj;
    }
}


// =========================================
// THREAD SAFE SINGLETON
// =========================================
class ThreadSafeSingletonClass{
    private static ThreadSafeSingletonClass obj;

    private ThreadSafeSingletonClass(){
        System.out.println("Created ThreadSafeSingletonClass object by "+ Thread.currentThread().getName());
    }

    public synchronized static ThreadSafeSingletonClass getInstance(){
        if(obj==null) {
            // Artificial delay
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            obj = new ThreadSafeSingletonClass();
        }
        return obj;
    }
}

// =========================================
// TASK FOR NON THREAD SAFE SINGLETON
// =========================================
class Trd implements Runnable{
    public void run(){
        SingletonClass obj = SingletonClass.getInstance();
        System.out.println(Thread.currentThread().getName() + " received object: " + obj);
    }
}

// =========================================
// TASK FOR THREAD SAFE SINGLETON
// =========================================
class Trd1 implements Runnable{
    public void run(){
        ThreadSafeSingletonClass obj = ThreadSafeSingletonClass.getInstance();
        System.out.println(Thread.currentThread().getName() + " received object: " + obj);
    }
}

public class Singleton {
    public static void main(String[] args){
//        Here we are trying to create objects multiple times in main class.\
        System.out.println("===== NORMAL SINGLETON TEST =====");
        SingletonClass obj1 = SingletonClass.getInstance();
        SingletonClass obj2 = SingletonClass.getInstance();
        System.out.println("Both objects are same: "+(obj1==obj2));
        System.out.println(Thread.currentThread().getName() + " received object: " + obj1);
        System.out.println("\n--------------------------------------\n");

//        Testing for non thread safe class
//        Note: The object created here and in the above is same. So to see the object created by these thread, comment
//              the above object creation logic for ("===== NORMAL SINGLETON TEST =====") and run this to see the
//              difference
        System.out.println("===== NON THREAD SAFE TEST =====");
        Runnable tr1 = new Trd();
        Runnable tr2 = new Trd();

        Thread t1 = new Thread(tr1, "Thread-1");
        Thread t2 = new Thread(tr2, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Testing for thread safe class
        System.out.println("\n--------------------------------------\n");
        System.out.println("===== THREAD SAFE TEST =====");
        Runnable r1 = new Trd1();
        Runnable r2 = new Trd1();

        Thread thread1 = new Thread(r1,"Thread-3");
        Thread thread2 = new Thread(r2, "Thread-4");

        thread1.start();
        thread2.start();

    }
}
