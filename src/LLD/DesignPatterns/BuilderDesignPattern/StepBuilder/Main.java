package LLD.DesignPatterns.BuilderDesignPattern.StepBuilder;

public class Main {
    public static void main(String[] args) {
        Request request = new Request.RequestStepBuilder()
                .withUrl("https://api.example.com")
                .withMethod("GET")
                .withBody("This is sample request")
                .withTimeout(30)
                .build();

        request.execute();

    }
}
