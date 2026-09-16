package LLD.DesignPatterns.StateDP;

// State Interface
interface VendingState{
    VendingState insertCoin(VendingMachine vendingMachine, int coins);
    VendingState selectItem(VendingMachine vendingMachine, int quantity);
    VendingState dispenseItem(VendingMachine vendingMachine);
    VendingState refillItem(VendingMachine vendingMachine, int quantity);
    String getStateName();
}

// State Concrete class
class NoCoinState implements VendingState{
    public VendingState insertCoin(VendingMachine vendingMachine, int coins){
        vendingMachine.setInsertedCoins(coins);
        System.out.println("Coin inserted. Current balance: Rs " + coins);
        return vendingMachine.getHasCoinState();
    }

    public VendingState selectItem(VendingMachine vendingMachine, int quantity){
        System.out.println("Please insert coin first!");
        return vendingMachine.getNoCoinState(); // Stay in same state
    }

    public VendingState dispenseItem(VendingMachine vendingMachine){
        System.out.println("Please insert coin first!");
        return vendingMachine.getNoCoinState(); // Stay in same state
    }

    public VendingState refillItem(VendingMachine vendingMachine, int quantity){
        System.out.println("Adding "+ quantity +" more items to machine");
        vendingMachine.setItemCount(vendingMachine.getItemCount()+quantity);
        return vendingMachine.getNoCoinState();
    }

    public String getStateName(){
        return "No Coin State";
    }
}

class HasCoinState implements VendingState{
    public VendingState insertCoin(VendingMachine vendingMachine, int coins){
        vendingMachine.setInsertedCoins(vendingMachine.getInsertedCoins()+coins);
        System.out.println("Coin inserted. Current balance: Rs " + vendingMachine.getInsertedCoins()+coins);
        return vendingMachine.getHasCoinState();
    }

    public VendingState selectItem(VendingMachine vendingMachine, int quantity){
        if(vendingMachine.getItemCount()>=quantity
                && vendingMachine.getInsertedCoins()>=vendingMachine.getItemPrice()*quantity){
            System.out.println("Dispensing "+quantity+" items");
            int remaining = vendingMachine.getItemCount()-quantity;
            vendingMachine.setItemCount(remaining);
            vendingMachine.setInsertedCoins(0);
            return vendingMachine.getDispenseState();
        } else if(vendingMachine.getItemCount()<quantity){
            System.out.println("Insufficient quantity");
            System.out.println("Returning "+vendingMachine.getInsertedCoins() +" to users");
            return vendingMachine.getRefillState();
        } else{
            System.out.println("Insufficient amount of coins");
            return vendingMachine.getHasCoinState();
        }
    }

    public VendingState dispenseItem(VendingMachine vendingMachine){
        System.out.println("Please select item quantity first");
        return vendingMachine.getHasCoinState();
    }

    public VendingState refillItem(VendingMachine vendingMachine, int quantity){
        System.out.println("Can't refill unless the action of dispensing is complete");
        return vendingMachine.getNoCoinState();
    }

    public String getStateName(){
        return "Has Coin State";
    }
}

class DispenseState implements VendingState{
    public VendingState insertCoin(VendingMachine vendingMachine, int coins){
        System.out.println("Can't insert coin in this state");
        return vendingMachine.getDispenseState();
    }

    public VendingState selectItem(VendingMachine vendingMachine, int quantity){
        System.out.println("Can't select items in this state");
        return vendingMachine.getDispenseState();
    }

    public VendingState dispenseItem(VendingMachine vendingMachine){
        System.out.println("Dispensing completed");
        if(vendingMachine.getItemCount()>0)
            return vendingMachine.getNoCoinState();
        return vendingMachine.getRefillState();
    }

    public VendingState refillItem(VendingMachine vendingMachine, int quantity){
        System.out.println("Can't refill unless the action of dispensing is complete");
        return vendingMachine.getDispenseState();
    }

    public String getStateName(){
        return "Dispensing State";
    }
}

class RefillState implements VendingState{
    public VendingState insertCoin(VendingMachine vendingMachine, int coins){
        System.out.println("Can't insert coin in this state");
        return vendingMachine.getRefillState();
    }

    public VendingState selectItem(VendingMachine vendingMachine, int quantity){
        System.out.println("Can't select items in this state");
        return vendingMachine.getRefillState();
    }

    public VendingState dispenseItem(VendingMachine vendingMachine){
        System.out.println("Can't dispense items in this state");
        return vendingMachine.getRefillState();
    }

    public VendingState refillItem(VendingMachine vendingMachine, int quantity){
        System.out.println("Refilling in progress...");
        System.out.println("Adding "+quantity +" items to machine");
        vendingMachine.setItemCount(vendingMachine.getItemCount()+quantity);
        System.out.println("Refilling completed successfully");
        return vendingMachine.getNoCoinState();
    }

    public String getStateName(){
        return "Refill State";
    }
}

class VendingMachine{
    private VendingState currentState;
    private int itemCount;
    private int itemPrice;
    private int insertedCoins;

    private VendingState noCoinState;
    private VendingState hasCoinState;
    private VendingState dispenseState;
    private VendingState refillState;

    public VendingMachine(int itemCount, int itemPrice){
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
        this.insertedCoins = 0;

        noCoinState = new NoCoinState();
        hasCoinState = new HasCoinState();
        dispenseState = new DispenseState();
        refillState = new RefillState();

        // Set initial state
        if (itemCount > 0) {
            currentState = noCoinState;
        } else {
            currentState = refillState;
        }
    }

    public void insertCoin(int coin){
        currentState = currentState.insertCoin(this,coin);
    }

    public void selectItem(int quantity){
        currentState = currentState.selectItem(this, quantity);
    }

    public void dispense(){
        currentState = currentState.dispenseItem(this);
    }

    public void refill(int quantity){
        currentState = currentState.refillItem(this, quantity);
    }

    public String getCUrrentState(){
        return currentState.getStateName();
    }

    public VendingState getRefillState() {
        return refillState;
    }

    public VendingState getHasCoinState() {
        return hasCoinState;
    }

    public VendingState getDispenseState() {
        return dispenseState;
    }

    public VendingState getNoCoinState() {
        return noCoinState;
    }

    public int getInsertedCoins() {
        return insertedCoins;
    }

    public void setInsertedCoins(int insertedCoins) {
        this.insertedCoins = insertedCoins;
    }

    public int getItemPrice() {
        return itemPrice;
    }


    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

}

public class StateDesignPattern {
    public static void main(String[] args) {
        System.out.println("=== Water Bottle VENDING MACHINE ===");
        VendingMachine vendingMachine = new VendingMachine(50, 5);

        vendingMachine.getCUrrentState();

        System.out.println("1. Asking for item without coins");
        vendingMachine.selectItem(2);
        vendingMachine.dispense();

        System.out.println("\n2. Correct flow");
        vendingMachine.insertCoin(10);
        vendingMachine.selectItem(2);
        vendingMachine.dispense();

        System.out.println("\n3. Asking for more item");
        vendingMachine.insertCoin(1);
        vendingMachine.selectItem(3);
        vendingMachine.dispense();

        System.out.println("\n4. Refilling");
        vendingMachine.refill(10);
        vendingMachine.insertCoin(100);
        vendingMachine.selectItem(8);
        vendingMachine.dispense();
    }
}
