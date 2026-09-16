package LLD.DesignPatterns.BuilderDP.SimpleBuilder;

public class Main {
    public static void main(String[] args) {
        HttpRequest request = new HttpRequest.HttpRequestBuilder()
                .withUrl("https://api.andromada.cosmos")
                .withMethod("POST")
                .withHeaders("Content-Type", "application/json")
                .withHeaders("Accept", "application/json")
                .withQueryParams("Age", "2 billion light years")
                .withBody("{\"name\": \"Ashish\"}")
                .withTimeout(60)
                .build();

        request.execute(); // Guaranteed to be in a consistent state
    }
}
