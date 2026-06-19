package LLD.DesignPatterns;

interface Engine{
    void start();
}

abstract class Car{
    protected Engine engine;

    public Car(Engine engine){
        this.engine = engine;
    }

    public abstract void drive();
}

class DieselEngine implements Engine{
    public void start(){
        System.out.println("Starting Diesel Engine");
    }
}


class PetrolEngine implements Engine{
    public void start(){
        System.out.println("Starting Petrol Engine");
    }
}


class XUV extends Car{
    public XUV(Engine engine){
        super(engine);
    }

    @Override
    public void drive(){
        engine.start();
        System.out.println("Driving XUV");
    }
}

class Sedan extends Car{
    public Sedan(Engine engine){
        super(engine);
    }

    @Override
    public void drive(){
        engine.start();
        System.out.println("Driving Sedan");
    }
}


public class BridgeDesignPattern {
    public static void main(String[] args) {
        PetrolEngine petrolEngine = new PetrolEngine();
        DieselEngine dieselEngine = new DieselEngine();

        XUV xuv = new XUV(petrolEngine);
        Sedan sedan = new Sedan(dieselEngine);

        xuv.drive();
        System.out.println("----------------------------");
        sedan.drive();

    }
}
