package oops;


class Config{
    public void show(){
        System.out.println("Reading the config file");
    }
}

// the only purpose of this class is to override the show method of Config class. Hence creating separate class for this
// doesn't make any sense and hence we will be using anonymous inner class for this.
class Sms extends Config{
    public void show(){
        System.out.println("Reading from SMS");
    }
}

public class AnonymousInnerClass {
    public static void main(String[] args){
        Config conf = new Config();
        conf.show();

        Config sms = new Sms();
        sms.show();

        // here obj is object of anonymous inner class
        Config obj = new Config(){
            public void show(){
                System.out.println("Printing from anonymous inner class");
            }
        };
        obj.show();

    }
}
