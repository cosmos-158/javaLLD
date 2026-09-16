package LLD.LLDQuestions.NotificationService;

import java.util.ArrayList;
import java.util.List;

class NotificationService{
    private static volatile NotificationService  instance;
    private final NotificationPublisher publisher;

    private NotificationService(){
        this.publisher = new NotificationPublisher();
    }

    public static NotificationService getInstance(){
        if(instance==null){
            instance = new NotificationService();
        }
        return instance;
    }

    public NotificationPublisher getPublisher() {
        return publisher;
    }

    public void publish(Notification notification){
        NotificationEvent notificationEvent = new NotificationEvent(notification);
        publisher.notifyObserver(notificationEvent);
    }

}

public class NotificationMain {
    public static void main(String[] args) {
        // Singleton Service
        NotificationService notificationService = NotificationService.getInstance();

        // Publisher
        NotificationPublisher notificationPublisher = notificationService.getPublisher();

        // Logger Observer
        Logger logger = new Logger();

        // Notification Engine
        NotificationEngine notificationEngine = new NotificationEngine();
        notificationEngine.addNotificationStrategy(new EmailStrategy("ashishchaurasia@earth.cosmos"));
        notificationEngine.addNotificationStrategy(new SMSStrategy("9975468976"));
        notificationEngine.addNotificationStrategy(new PushNotificationStrategy());

        notificationPublisher.addObserver(logger);
        notificationPublisher.addObserver(notificationEngine);

        /* =========================
                CREATE NOTIFICATION
           ========================= */

        Notification notification = new SimpleNotification("Your order has been shipped!");
        notificationService.publish(notification);

        // Add timestamp
        System.out.println("\n---------------------------------------------------");
        notification = new TimestampNotificationDecorator(notification);
        notificationService.publish(notification);

        // Add encryption
        System.out.println("\n---------------------------------------------------");
        notification = new EncryptionDecorator(notification);
        notificationService.publish(notification);

        // Add signature
        System.out.println("\n---------------------------------------------------");
        notification = new SignatureNotificationDecorator(notification,"Amazon Customer Care");
        notificationService.publish(notification);


    }
}
