package LLD.DesignPatterns.ProxyDP;

interface DocumentReader{
    void unlock(String filepath);
}

class RealDocument implements DocumentReader{
    @Override
    public void unlock(String filepath){
        System.out.println("[RealDocument] Opening PDF: " + filepath);
        System.out.println("[RealDocument] PDF content displayed.");
    }
}

class User{
    private final String username;
    private final String password;
    private final boolean isPremium;

    public User(String username, String password, boolean premium) {
        this.username = username;
        this.password = password;
        this.isPremium = premium;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isPremium() {
        return isPremium;
    }
}

class DocumentProxy implements DocumentReader{
    private final DocumentReader realDocument;
    private final User registeredUser;

    private String enteredUsername;
    private String enteredPassword;

    public DocumentProxy(User registeredUser) {
        this.registeredUser = registeredUser;
        this.realDocument = new RealDocument();
    }

    public boolean authenticate(String username, String password) {

        this.enteredUsername = username;
        this.enteredPassword = password;

        if (!registeredUser.isPremium()) {
            System.out.println("[Proxy] Access Denied. Premium membership required.");
            return false;
        }

        if (!registeredUser.getUsername().equals(username)
                || !registeredUser.getPassword().equals(password)) {

            System.out.println("[Proxy] Access Denied. Invalid credentials.");
            return false;
        }

        System.out.println("[Proxy] Authentication Successful.");
        return true;
    }


    @Override
    public void unlock(String filePath) {

        if (enteredUsername == null || enteredPassword == null) {
            System.out.println("[Proxy] User not authenticated.");
            return;
        }

        realDocument.unlock(filePath);
    }

}

public class ProtectionProxy {
    public static void main(String[] args) {
        User premiumUser = new User("ashish158", "123321741", true);

        User nonPremiumUser = new User("inder0106", "987654321", false);

        System.out.println("===== Premium User with correct credentials=====");
        DocumentProxy proxy = new DocumentProxy(premiumUser);
        if (proxy.authenticate("ashish158", "123321741")) {
            proxy.unlock("WorldWarDetails3.pdf");
        }
        System.out.println("\n===== Premium User with incorrect credentials=====");
        if (proxy.authenticate("ashish158", "134")) {
            proxy.unlock("WorldWarDetails3.pdf");
        }

        System.out.println();
        System.out.println("===== Non Premium User =====");

        DocumentProxy proxy2 = new DocumentProxy(nonPremiumUser);
        if (proxy2.authenticate("inder0106", "987654321")) {
            proxy2.unlock("WorldWarDetails3.pdf");
        }

    }
}
