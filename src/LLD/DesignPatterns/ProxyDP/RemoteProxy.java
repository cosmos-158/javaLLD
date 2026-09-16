package LLD.DesignPatterns.ProxyDP;

interface DataService{
    String fetchData();
}

class RealDataService implements DataService{
    public RealDataService(){
        // Imagine this connects to a remote server or loads heavy resources.
        System.out.println("[RealDataService] Initialized (simulating remote setup)");
    }

    @Override
    public String fetchData() {
        return "[RealDataService] Data from server";
    }
}

// Remote proxy
class DataServiceProxy implements DataService {
    private RealDataService realService;

    public DataServiceProxy() {
        realService = new RealDataService();
    }

    @Override
    public String fetchData() {
        System.out.println("[DataServiceProxy] Connecting to remote service...");
        return realService.fetchData();
    }
}

public class RemoteProxy {
    public static void main(String[] args) {
        DataService dataService = new DataServiceProxy();
        dataService.fetchData();
    }
}
