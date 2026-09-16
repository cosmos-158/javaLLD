package LLD.DesignPatterns.AdapterDP;

// 1. Target interface expected by the client
interface Report{
    String getJsonData();
}

// 2. Adaptee: provides XML data from a raw input
class XmlDataProvider{
    private String data;

    public XmlDataProvider(String data){
        this.data = data;
        System.out.println("XML Data: "+data);
    }

    public String getXmlData(){
        int sep = data.indexOf(':');
        String name = data.substring(0, sep);
        String id   = data.substring(sep + 1);
        // Build an XML representation
        return "<user>"
                + "<name>" + name + "</name>"
                + "<id>"   + id   + "</id>"
                + "</user>";
    }
}

// 3. Adapter: implements IReports by converting XML → JSON
class XmlDataProviderAdapter implements Report{
    private XmlDataProvider xmlDataProvider;

    public XmlDataProviderAdapter(XmlDataProvider xmlDataProvider){
        this.xmlDataProvider = xmlDataProvider;
    }

    public String getJsonData(){
        String xmlData = xmlDataProvider.getXmlData();
        int startName = xmlData.indexOf("<name>") + 6;
        int endName   = xmlData.indexOf("</name>");
        String name   = xmlData.substring(startName, endName);

        int startId = xmlData.indexOf("<id>") + 4;
        int endId   = xmlData.indexOf("</id>");
        String id    = xmlData.substring(startId, endId);

        return "{\"name\":\"" + name + "\", \"id\":" + id + "}";
    }
}

// 4. Client code works with only Report

class Client{
    private Report report;
    public Client(Report report){
        this.report =  report;
    }

    public String getJsonData(){
        String data = report.getJsonData();
        return data;
    }

}

public class AdapterDesignPattern {
    public static void main(String[] args) {
        XmlDataProvider xmlDataProvider = new XmlDataProvider("Ashish:26");

        Client client = new Client(new XmlDataProviderAdapter(xmlDataProvider));

        System.out.println("Processed Json: "+client.getJsonData());
    }
}
