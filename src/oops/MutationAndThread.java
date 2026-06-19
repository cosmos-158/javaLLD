package oops;

/*
    If we are working simultaneously with threads and mutable objects. Then make sure to make mutable objects thread
    safe. Thread safe means that only one thread can work with that object/method at one time.
*/

class Counter{
    int count = 0;
    public void increment(){
        count++;
    }
    // comment one and uncomment other for sync and async operation.
//    public synchronized void increment(){
//        count++;
//    }
}

class Trd implements Runnable{
    Counter cnt;
    public Trd(Counter cnt){
        this.cnt = cnt;
    }

    public void run(){
        for(int i=1;i<=100000;i++) {
            this.cnt.increment();
        }
    }
}

public class MutationAndThread {
    public static void main(String[] args) throws InterruptedException {
        Counter obj = new Counter();

        Runnable rnb = new Trd(obj);

        Thread t1 = new Thread(rnb);
        Thread t2 = new Thread(rnb);

        t1.start();
        t2.start();

        Thread.sleep(5);
        /*
            this will show random value and not 100000+100000=200000 since all three threads i.e. main and t1 and t2 will
            be running parallely and most likely before t1 and t2 complete the main will also complete and will print some
            random value.
        */
        System.out.println("Value of counter before joining both the threads: "+obj.count);

        /*
            Now in order to wait for t1 and t2 to complete we need to join both the threads using join to main thread.
            This however doesn't guarantee that the value will be 100000+100000=200000 at the end since two threads are
            independently modifying this and it is possible that one thread updates count but the other thread doesn't
            get the latest value and makes updates on older value.
        */
        t1.join();
        t2.join();

        Thread.sleep(5);
        System.out.println("Value of counter after joining both the threads: "+obj.count);

        /* In order to make sure that only one thread interferes with the object at one time, we use synchronized
           keyword as given there in the Counter class (commented out part).
        */

        /*
            States of thread:
                New : when we do thread = new thread()
                Runnable : when we use thread.start() then it is at runnable state
                Running : when it is actually running on CPU using run() method
                Waiting : when we use sleep(), wait() then it goes to waiting state. Further we use notify() to bring it
                          back to runnable state and it goes to running state when scheduler allows it.
                Dead : once the thread work is over then it goes to dead state. We can also use stop() to send it to
                       dead state.
        */
    }
}