package LLD.SOLID;

import java.util.ArrayList;

interface DepositOnlyAccount{
    void deposit(int amount);
}

interface WithdrawableAccount extends DepositOnlyAccount{
    void withdraw(int amount);
}

class SavingBankAccount implements WithdrawableAccount{
    int balance;
    public SavingBankAccount(){
        this.balance = 0;
    }

    public void deposit(int amount){
        this.balance+=amount;
        System.out.println("Saving Account - Deposited : "+amount);
    }

    public void withdraw(int amount){
        if(this.balance>amount) {
            System.out.println("Saving Account - Withdrawn : " + amount);
            this.balance -= amount;
        }
        else
            System.out.println("Insufficient Balance....");
    }
}

class CurrentBankAccount implements WithdrawableAccount{
    int balance;
    public CurrentBankAccount(){
        this.balance = 0;
    }

    public void deposit(int amount){
        this.balance+=amount;
        System.out.println("Current Account - Deposited : "+amount);
    }

    public void withdraw(int amount){
        if(this.balance>amount) {
            System.out.println("Current Account - Withdrawn : " + amount);
            this.balance -= amount;
        }
        else
            System.out.println("Insufficient Balance....");
    }
}

class FixedDeposistAccount implements DepositOnlyAccount{
    int balance;
    public FixedDeposistAccount(){
        this.balance = 0;
    }

    public void deposit(int amount){
        this.balance+=amount;
        System.out.println("Fixed Deposit - Withdrawn : " + amount);
    }
}

class Clients{
    ArrayList<DepositOnlyAccount> da;
    ArrayList<WithdrawableAccount> wa;

    public Clients(ArrayList<DepositOnlyAccount> da, ArrayList<WithdrawableAccount> wa){
        this.da = da;
        this.wa = wa;
    }

    public void processTransaction(){
        for(WithdrawableAccount it : this.wa){
            it.deposit(1000);
            it.withdraw(500);
        }
        for(DepositOnlyAccount it : this.da){
            it.deposit(1500);
        }
    }
}

public class LiskovSubstitutionFollowed {
    public static void main(String[] args){
        ArrayList<WithdrawableAccount> wa = new ArrayList<>();
        ArrayList<DepositOnlyAccount> da = new ArrayList<>();

        wa.add(new SavingBankAccount());
        wa.add(new CurrentBankAccount());
        da.add(new FixedDeposistAccount());

        Clients c = new Clients(da,wa);
        c.processTransaction();
    }
}
