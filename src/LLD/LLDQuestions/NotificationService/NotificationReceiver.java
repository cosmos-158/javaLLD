package LLD.LLDQuestions.NotificationService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/* =========================================================
                    OBSERVER PATTERN
   ========================================================= */


// Observable / Publisher
interface Observable{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(NotificationEvent notificationEvent);
}

// Concrete Observable
class NotificationPublisher implements Observable{
    protected final List<Observer> observerList;
    public NotificationPublisher(){
        this.observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer){
        if(!this.observerList.contains(observer))
            this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObserver(NotificationEvent notificationEvent){
        for(Observer Observer : observerList){
            Observer.update(notificationEvent);
        }
    }
}

// Observer
interface Observer{
    void update(NotificationEvent notificationEvent);
}

/* =========================================================
                    LOGGER OBSERVER
   ========================================================= */
class Logger implements Observer{
    public void update(NotificationEvent notificationEvent){
        System.out.println("[LOGGER] Notification Logged:\n" + notificationEvent.getContent());
    }
}

/* =========================================================
                    EVENT OBJECT
   ========================================================= */
class NotificationEvent{
    private final String content;
    private final LocalDateTime createdAt;
    public NotificationEvent(Notification notification){
        this.content = notification.getContent();
        this.createdAt = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}

/* =========================================================
                    STRATEGY PATTERN
   ========================================================= */

// Strategy
interface NotificationStrategies{
    void sendNotification(String text);
}

// Concrete Strategy 1
class EmailStrategy implements NotificationStrategies{
    private final String emailId;
    public EmailStrategy(String emailId){
        this.emailId = emailId;
    }

    public void sendNotification(String text){
        System.out.println("[EMAIL SENT]" + "\nTo: " + emailId + "\nMessage:\n" + text);
    }
}

// Concrete Strategy 2
class SMSStrategy implements NotificationStrategies{
    private final String mobileNo;

    public SMSStrategy(String mobileNo){
        this.mobileNo = mobileNo;
    }

    public void sendNotification(String text){
        System.out.println("[SMS SENT]" + "\nTo: " + mobileNo + "\nMessage:\n" + text);
    }
}

// Concrete Strategy 3
class PushNotificationStrategy implements NotificationStrategies {
    @Override
    public void sendNotification(String content) {
        System.out.println("[PUSH NOTIFICATION]" + "\nMessage:\n"+ content);
    }
}


/* =========================================================
                NOTIFICATION ENGINE OBSERVER
   ========================================================= */

class NotificationEngine implements Observer{
    private List<NotificationStrategies> strategies;
    public NotificationEngine(){
        this.strategies = new ArrayList<>();
    }

    public void addNotificationStrategy(NotificationStrategies notificationStrategies){
        this.strategies.add(notificationStrategies);
    }

    public void update(NotificationEvent notificationEvent){
        for(NotificationStrategies notificationStrategies : strategies){
            notificationStrategies.sendNotification(notificationEvent.getContent());
        }
    }
}

public class NotificationReceiver {

}
