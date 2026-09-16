package LLD.DesignPatterns.BuilderDP.BuilderWithDirector;

// we define commonly used methods over here in order for user to avoid writng withXYZ thing again and again.

public class HttpRequestDirector {
    public static HttpRequest createGetRequest(String url){
        return new HttpRequest.HttpRequestBuilder()
                .withUrl(url)
                .withMethod("GET")
                .build();
    }

    public static HttpRequest createJsonPOSTRequest(String url, String jsonBody){
        return new HttpRequest.HttpRequestBuilder()
                .withUrl(url)
                .withMethod("POST")
                .withHeader("Content-Type", "application/json")
                .withHeader("Accept", "application/json")
                .withBody(jsonBody)
                .build();
    }
}
