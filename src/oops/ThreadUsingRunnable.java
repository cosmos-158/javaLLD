package oops;

/* There are two ways of creating threads, one is using Thread class and the other is using Runnable interface.
   The only thing is that Runnable interface will not have thread methods and in that case we need to create separate
    thread objects and link the Runnable object and thread objects to use these features.
 */

class Thread1 implements Runnable{
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println("Hi..");
        }
    }
}

class Thread2 implements Runnable{
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println("Hello..");
        }
    }
}

public class ThreadUsingRunnable {
    public static void main(String[] args){
        Runnable r1 = new Thread1();
        Runnable r2 = new Thread2();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }
}
