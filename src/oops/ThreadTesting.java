package oops;

class TestThreadClass extends Thread{
    public void run(){
        for(int i=1;i<=5;i++) {
            System.out.println("Thread T1 executing " + i + "...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadTesting {
    public static void main(String[] args){
        TestThreadClass t1 = new TestThreadClass();
        t1.start();

        for(int i=1;i<=5;i++){
            System.out.println("Main thread executing "+i+"...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
