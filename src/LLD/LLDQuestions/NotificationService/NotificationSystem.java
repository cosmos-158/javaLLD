package LLD.LLDQuestions.NotificationService;

/*
    Decorator Design Pattern
*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface
interface Notification{
    String getContent();
}

// Concrete Class
class SimpleNotification implements Notification{
    private final String text;
    public SimpleNotification(String text){
        this.text = text;
    }

    @Override
    public String getContent(){
        return this.text;
    }
}


// Decorator Abstract Class
abstract class NotificationDecorator implements Notification{
    protected final Notification notification;
    public NotificationDecorator(Notification notification){
        this.notification = notification;
    }

}
// Concrete Decorator Class
class TimestampNotificationDecorator extends NotificationDecorator{
    public TimestampNotificationDecorator(Notification notification){
        super(notification);
    }

    @Override
    public String getContent(){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return "[" + timestamp + "]" + notification.getContent();
    }
}

class SignatureNotificationDecorator extends NotificationDecorator{
    private final String signature;
    public SignatureNotificationDecorator(Notification notification, String signature){
        super(notification);
        this.signature = signature;
    }

    @Override
    public String getContent(){
        return notification.getContent() + "\nRegards,\n" + signature + "\n";
    }
}

class EncryptionDecorator extends NotificationDecorator {
    public EncryptionDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public String getContent() {
        return "ENCRYPTED{" + notification.getContent() + "}";
    }
}

public class NotificationSystem {

}
