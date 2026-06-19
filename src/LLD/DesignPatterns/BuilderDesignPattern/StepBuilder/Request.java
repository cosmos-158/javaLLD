package LLD.DesignPatterns.BuilderDesignPattern.StepBuilder;


public class Request {
    private String url;
    private String method;
    private String body;
    private int timeout;

    public void execute(){
        System.out.println("This is done using Step Builder");
        System.out.println("Executing "+ method + " request " + "to " + url);
        System.out.println("Body: " + body);
        System.out.println("Timeout " + timeout);
    }

    interface UrlStep{
        MethodStep withUrl(String url);
    }

    interface MethodStep{
        BodyStep withMethod(String method);
    }

    interface BodyStep{
        OptionalStep withBody(String body);
    }

    interface OptionalStep {
        OptionalStep withTimeout(int timeout);
        Request build();
    }

    public static class RequestStepBuilder implements UrlStep, MethodStep, BodyStep, OptionalStep{
        private Request req;

        public RequestStepBuilder(){
            req = new Request();
        }

        public MethodStep withUrl(String url){
            req.url = url;
            return this;
        }

        public BodyStep withMethod(String method){
            req.method = method;
            return this;
        }

        public OptionalStep withBody(String body){
            req.body = body;
            return this;
        }

        public OptionalStep withTimeout(int timeout){
            req.timeout = timeout;
            return this;
        }

        public Request build(){
            if(req.url==null || req.url.isEmpty())
                throw new RuntimeException("Url cannot be empty");
            return req;
        }
    }
}
