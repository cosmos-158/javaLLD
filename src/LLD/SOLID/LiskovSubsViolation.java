package LLD.SOLID;

import java.util.ArrayList;

interface Account{
    void deposit(int amount);
    void withdraw(int amount);
}

class SavingAccount implements Account{
    int balance;

    public SavingAccount(){
        this.balance = 0;
    }

    public void deposit(int amount){
        this.balance += amount;
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

class CurrentAccount implements Account{
    int balance;

    public CurrentAccount(){
        this.balance = 0;
    }

    public void deposit(int amount){
        this.balance += amount;
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

// now let's say another class FixedDepositAccount comes, then it won't be having withdraw method since we cannot
// withdraw from FD. Hence to add this we will need to modify parent class/Interface. Also this is not substitutable for
// its parent. Hence this violates Liskov Substitution Principle

class FixedDepositAccount implements Account{
    int balance;

    public FixedDepositAccount(){
        this.balance = 0;
    }

    public void deposit(int amount){
        this.balance += amount;
        System.out.println("Deposited : "+amount);
    }

    public void withdraw(int amount){
        throw new RuntimeException("Cannot withdraw from Fixed Deposit Account....");
    }
}

class Client{
    ArrayList<Account> arr = new ArrayList<>();

    public Client(ArrayList<Account> ac){
        this.arr = ac;
    }

    public void processTransaction(){
        for(Account a : this.arr){
            a.deposit(1000);
            try{
                a.withdraw(500);
            } catch (Exception e) {
                System.out.println("Exception occurred "+ e);
                throw e;
            }
        }
    }

}

public class LiskovSubsViolation {
    public static void main(String[] args){
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new CurrentAccount());
        accounts.add(new SavingAccount());
        accounts.add(new FixedDepositAccount());

        Client c = new Client(accounts);
        c.processTransaction();
    }
}
