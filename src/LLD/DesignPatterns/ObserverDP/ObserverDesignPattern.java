package LLD.DesignPatterns.ObserverDP;

import java.util.ArrayList;
import java.util.List;

interface Channel{
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifyUsers();
}

interface Subscriber{
    void update();
}

class ConcreteChannel implements Channel{
    List<Subscriber> subscriberList;
    private String name;
    private String title;

    public ConcreteChannel(String name){
        this.name = name;
        this.subscriberList = new ArrayList<>();
    }

    public void subscribe(Subscriber subscriber){
        if(!subscriberList.contains(subscriber))
            this.subscriberList.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber){
        subscriberList.remove(subscriber);
    }

    public void notifyUsers(){
        for(Subscriber subscriber : subscriberList){
            subscriber.update();
        }
    }

    public void uploadVideo(String title){
        this.title = title;
        System.out.println("\n[" + name + " uploaded \"" + title + "\"]");
        notifyUsers();
    }

    public String getVideo() {
        return "\nCheckout our new Video : " + this.title + "\n";
    }
}

class SubscriberConcrete implements Subscriber{
    private ConcreteChannel channel;
    private String name;
    public SubscriberConcrete(String name, ConcreteChannel channel){
        this.name = name;
        this.channel = channel;
    }

    public void update() {
        System.out.println("Hey " + this.name + "," + this.channel.getVideo());
    }

}

public class ObserverDesignPattern {
    public static void main(String[] args){
        ConcreteChannel channel = new ConcreteChannel("CoderArmy");

        SubscriberConcrete subs1 = new SubscriberConcrete("Ashish", channel);
        SubscriberConcrete subs2 = new SubscriberConcrete("Inder", channel);

        // Ashish and Inder subscribe to CoderArmy
        channel.subscribe(subs1);
        channel.subscribe(subs2);

        // Upload a video: both Ashish and Inder are notified
        channel.uploadVideo("Observer Pattern Tutorial");

        // Inder unsubscribes; Tarun remains subscribed
        channel.unsubscribe(subs1);

        // Upload another video: only Ashish is notified
        channel.uploadVideo("Decorator Pattern Tutorial");
    }
}
