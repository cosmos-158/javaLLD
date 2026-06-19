package LLD.DesignPatterns;


abstract class MoneyHandler{
    protected MoneyHandler nextHandler;

    public MoneyHandler(){
        this.nextHandler = null;
    }

    public void setNextHandler(MoneyHandler moneyHandler){
        this.nextHandler = moneyHandler;
    }

    public abstract void dispense(int amount);
}

class ThousandHandler extends MoneyHandler{
    private int noteCount;

    public ThousandHandler(int noteCount){
        this.noteCount = noteCount;
    }

    @Override
    public void dispense(int amount) {
        int notes = amount/1000;
        int rem = amount%1000;

        if(notes>noteCount){
            System.out.println("Insufficient cash...");
        } else {
            noteCount-=notes;
            System.out.println("Dispensing " + notes + " x ₹1000 notes.");
            if(rem>0){
                if(nextHandler!=null) {
                    nextHandler.dispense(rem);
                }
                else{
                    System.out.println("Remaining amount of " + rem + " cannot be fulfilled (Insufficinet fund in ATM)");
                }
            }
        }
    }
}

class FiveHundredHandler extends MoneyHandler{
    private int noteCount;

    public FiveHundredHandler(int noteCount){
        this.noteCount = noteCount;
    }

    @Override
    public void dispense(int amount) {
        int notes = amount/500;
        int rem = amount%500;

        if(notes>noteCount){
            System.out.println("Insufficient cash...");
        } else {
            noteCount-=notes;
            System.out.println("Dispensing " + notes + " x ₹500 notes.");
            if(rem>0){
                if(nextHandler!=null) {
                    nextHandler.dispense(rem);
                }
                else{
                    System.out.println("Remaining amount of " + rem + " cannot be fulfilled (Insufficinet fund in ATM)");
                }
            }
        }
    }
}

class HundredHandler extends MoneyHandler{
    private int noteCount;

    public HundredHandler(int noteCount){
        this.noteCount = noteCount;
    }

    @Override
    public void dispense(int amount) {
        int notes = amount/100;
        int rem = amount%100;

        if(notes>noteCount){
            System.out.println("Insufficient cash...");
        } else {
            noteCount-=notes;
            System.out.println("Dispensing " + notes + " x ₹100 notes.");
            if(rem>0){
                if(nextHandler!=null) {
                    nextHandler.dispense(rem);
                }
                else{
                    System.out.println("Remaining amount of " + rem + " cannot be fulfilled (Insufficinet fund in ATM)");
                }
            }
        }
    }
}


public class ChainOfResponsibility {
    public static void main(String[] args) {
        MoneyHandler thousandHandler = new ThousandHandler(5);
        MoneyHandler fiveHundredHandler = new FiveHundredHandler(5);
        MoneyHandler hundredHandler = new HundredHandler(5);

        thousandHandler.setNextHandler(fiveHundredHandler);
        fiveHundredHandler.setNextHandler(hundredHandler);

        thousandHandler.dispense(1000);


    }
}
