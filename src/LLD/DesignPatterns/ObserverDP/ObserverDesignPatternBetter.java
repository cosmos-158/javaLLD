package LLD.DesignPatterns.ObserverDP;

import java.util.ArrayList;
import java.util.List;

// Interface for Observable

interface Platform{
    void subscribe(Person user);
    void unsubscribe(Person user);
    void notifyUsers(VideoEvent event);
}

// interface for observers
interface User{
    void update(VideoEvent event);
}

// Concrete Class for observers
class Person implements User{
    private String name;

    public Person(String name){
        this.name = name;
    }

    public void update(VideoEvent event){
        System.out.println("Hey "+this.name+"!\n Checkout the new video on "+event.getTitle()+" uploaded by "+event.getName()+"\n");
    }
}


// Class that interacts with both observer and observable in form of event. This is for decoupling observable and
// observer
class VideoEvent{
    private String channelName;
    private String title;

    public VideoEvent(String name, String title){
        this.channelName = name;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return channelName;
    }
}


// Concrete Observable Class
class YoutubeChannel implements Platform{
    private String channelName;
    private List<User> subscriberList;

    public YoutubeChannel(String name){
        this.channelName = name;
        this.subscriberList = new ArrayList<>();
    }

    public void subscribe(Person subscriber){
        if(!subscriberList.contains(subscriber))
            this.subscriberList.add(subscriber);
    }

    public void unsubscribe(Person subscriber){
        this.subscriberList.remove(subscriber);
    }

    public void notifyUsers(VideoEvent event){
        for(User subscriber : subscriberList){
            subscriber.update(event);
        }
    }

    public void uploadVideo(String title){
        System.out.println(this.channelName + " uploaded a video on: "+ title+"\n");
        notifyUsers(new VideoEvent(this.channelName, title));
    }

}


// Dviver Class
public class ObserverDesignPatternBetter {

    public static void main(String[] args) {
        Person person1 = new Person("Ashish Chaurasia");
        Person person2 = new Person("Inder Kumar");
        Person person3 = new Person("Jatin Maniyar");

        YoutubeChannel channel = new YoutubeChannel("System Design");

        channel.subscribe(person1);
        channel.subscribe(person2);
        channel.subscribe(person3);

        channel.uploadVideo("Observer Design Pattern");

        System.out.println("\n--------------after someone unsubscribes-------------\n");
        channel.unsubscribe(person3);
        channel.uploadVideo("Factory Design Pattern");

    }
}