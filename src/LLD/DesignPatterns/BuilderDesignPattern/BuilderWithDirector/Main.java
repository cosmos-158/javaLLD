package LLD.DesignPatterns.BuilderDesignPattern.BuilderWithDirector;

import LLD.DesignPatterns.BuilderDesignPattern.BuilderWithDirector.HttpRequest;

public class Main {
    public static void main(String[] args) {
        HttpRequest request = new HttpRequest.HttpRequestBuilder()
                .withUrl("https://api.example.com")
                .withMethod("POST")
                .withHeader("Content-Type", "application/json")
                .withHeader("Accept", "application/json")
                .withQueryParams("key", "12345")
                .withBody("{\"name\": \"Aditya\"}")
                .withtimeout(60)
                .build();

        request.execute(); // Guaranteed to be in a consistent state

        System.out.println("\n----------------------------\n");

        HttpRequest getRequest = HttpRequestDirector.createGetRequest("https://api.example.com/users");
        getRequest.execute();

        System.out.println("\n----------------------------\n");

        HttpRequest postRequest = HttpRequestDirector.createJsonPOSTRequest(
                "https://api.example.com/users",
                "{\"name\": \"Ashish\", \"email\": \"ashish@example.com\"}");
        postRequest.execute();
    }
}
