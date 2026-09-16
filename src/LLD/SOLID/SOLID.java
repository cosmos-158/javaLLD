package LLD.SOLID;
/*
    S: Single Responsibility Principle (SRP):
        A class should have only one reason to change.
        A class should do only one thing.

    O: Open Close Principle:
        A class should be open for extension but close for modification

    L: Liskov Substitution Principle:
        Subclasses should be substitutable for their base classes. i.e. (inheritance should be followed properly)
            (Agar Child class, Parent class ko inherit karti hai, to jahan bhi Parent object use ho raha hai, wahan
            Child object bhi bina kisi problem ke use ho jana chahiye.)
        Child class should not narrow down the functionality of parent class rather it should expand it.
          Signature Rule: [(Method argument rule, return type rule and exception rule)]
            Method Argument Rule : Method k arguments same hone chahie parent and child me
            Return Type Rule : Child class k method ka return type ya to same ho ya narrow ho.
            Exception Rule : Child class k method parent class k ya to same exception ya fir narrower exception return
                             kre.
          Property Rule: [(Class Invariant Rule and History Constraint Rule)]
            Class Invariant : Child class parent class k rules ko ya as it is follow kre ya strengthen kare.
            History Constraint : Subclass methods should not be allowed to change state of parent class.
          Method Rule: [(Pre Condition and Post Condition)]
            Pre-condition : Child class parent class ki precondition ko ya as it follow kre ya weak kre.
            Post-condition : Child class parent class ki post condition ko ya as it is follow kre ya strengthen kre.

    I: Interface segregation principle
        Many client specific interface are better than one general purpose interface. Client should not be forced to
        implement methods they don't use.

    D: Dependency Inversion Principle
        High level module should not depend on low level module but rather both should depend on abstraction
        i.e. high level low level se direct baat na kare and vice versa and dono ek doosre se interface k through baat
        kre.

     Note: If open close principle is target then dependency inversion principle is solution.
 */

public class SOLID {
    public static void main(String[] args[]){
        System.out.println("SOLID Principles....");
    }
}
