package LLD.DesignPatterns.BuilderDP.BuilderWithDirector;

import java.util.*;

public class HttpRequest {
    private String url;
    private String method;
    private String body;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private int timeout;

    HttpRequest(){
        headers = new HashMap<>();
        queryParams = new HashMap<>();
    }

    public void execute(){
        System.out.println("Executing "+ method +" request to "+url);
        if(!queryParams.isEmpty()){
            System.out.println("Query Parametrrs:");
            for(Map.Entry<String, String> params : queryParams.entrySet()){
                System.out.println(" " + params.getKey() + "=" + params.getValue());
            }
        }

        System.out.println("Headers:");
        for(Map.Entry<String,String> header: headers.entrySet()){
            System.out.println(" " + header.getKey() + "=" + header.getValue());
        }

        if(body!=null && !body.isEmpty()){
            System.out.println("Body: "+body);
        }

        System.out.println("Timeout: " + timeout + " seconds");
        System.out.println("Request Executed Successfully");
    }

    public static class HttpRequestBuilder{
        private final HttpRequest req;

        public HttpRequestBuilder(){
            req = new HttpRequest();
        }

        public HttpRequestBuilder withUrl(String url){
            req.url = url;
            return this;
        }

        public HttpRequestBuilder withBody(String body){
            req.body = body;
            return this;
        }

        public HttpRequestBuilder withMethod(String method){
            req.method = method;
            return this;
        }

        public HttpRequestBuilder withHeader(String key, String value){
            req.headers.put(key,value);
            return this;
        }

        public HttpRequestBuilder withQueryParams(String key, String value){
            req.queryParams.put(key,value);
            return this;
        }

        public HttpRequestBuilder withtimeout(int timeout){
            req.timeout = timeout;
            return this;
        }


        public HttpRequest build(){
            if(req.url==null || req.url.isEmpty())
                throw new RuntimeException("Url cannot be empty");
            return req;
        }
    }

}
