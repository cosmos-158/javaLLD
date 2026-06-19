package LLD.DesignPatterns;

/*
    Strategy Design Pattern: (The solution to inheritance is not more inheritance.)
        Defines a family of Algorithm, put them into separate classes so that they can be
        changed at runtime.
        (
            This uses polymorphism to follow DRY.
            This favors composition over inheritance.
            Client has all the references to the algorithm classes.
            Client (has a, one to many)-> Strategies (Many)
        )
        - Encapsulate what varies and keep it separate from what remains same.
        - Solution to inheritance is not more inheritance.
        - Composition should be favoured over inheritance.
        - Code to interface and not to concrete implementation.
        - Do Not Repeat yourself.

     Factory Design Pattern:
        (
            Goal is to keep business logic separate from object creation logic.
            Client ko jab bhi object banana hoga vo factory ko bolega object k lie and factory will create object and
            give it to client. Client ko object kaise create ho raha iska idea nahi hoga
        )
        Simple Factory : This is design principle and not any pattern.
                         A factory class that decides which concrete class to instantiate.
        Factory Method : Ye khud me design pattern hai.
                         Defines an interface for creating Objects but allows subclass to decide which class to
                         instantiate.
        Abstract Factory Method : Ye khud me design pattern hai.
                                  Provides an interface for creating families of related objects without
                                  specifying their concrete classes.

     Singleton Design Pattern:
        Definition: Here class has only one instance while providing a global access point to that instance.

     -------------------- Above three used in Zomato------------------------------

     Observer Design Pattern:
        Definition: Defines a one-to-many relationship b/w objects so that when one object changes state, all of its
                    dependents are notified and updated automatically.

     Decorator Design Pattern:
        Definition: Decorator pattern attaches additional responsibilities to an object dynamically. Decorator provides
                    a flexible alternative to subclassing for extending functionality.
            (Inheritance with additional capabilities)

     ---------------------------- Above two used in Notification Services-----------------------------------------

     Command Design Pattern:
        Definition: Encapsulate a Request as an Object, thereby letting you paramaterize clients with different request,
                    queue or log request and support undoable operations.

     Adapter Design Pattern: (Intent is make communication b/w two completely different interfaces).
        Adapter is used to interact between existing code and third party library.
        [Existing code] <--> [Adapter] <--> [Third Party Library]
        Definition: Adapter converts the interface of a class into another interface that client expects.
                    Adapter lets classes work together that couldn't otherwise because of incompatible interface.

     Facade Design Pattern: (Intent is to hide the complexity of subsystem from client).
        [Client] <--> [Facade Class] <--> [Complex Subsystem]
        Principle of Least Knowledge:
            Take any object, now from any method in that object, principle tells you to invoke only methods that belong
            to:
                1. The object itself.
                2. The object passed in as a parameter to the method.
                3. Any object that method creates.
                4. Any object with (has - a) relationship.

        Definition: Facade pattern provides a simplified, unified interface to a set of Complex subsystem. It hides the complexity
                    of the system and exposes only what is necessary.

     Composite Design Pattern:
        Definition: Composite pattern composes object into tree like structure representing a part-whole hierarchy, It
        let client treats individual object and composition of object uniformly.

     Template Method Pattern:
        Template method pattern design the skeleton of an algorithm, for an operation deferring some steps to
        subclasses. Template method let subclasses redefine certain steps of an algorithm without changing the algorithm
        structure.

    Proxy Design Pattern :
        Definition: The proxy pattern provides a surrogate or a placeholder for another object to control access to it.
            - Virtual Proxy: A virtual proxy delays the creation of an expensive object until it is actually needed
                             (lazy initialization).
            - Protection Proxy: A protection proxy controls access to the real object based on permissions, roles,
                                or security rules.
            - Remote Proxy: A remote proxy represents an object that exists in a different address space, machine,
                            or network location.

    Chain of Responsibility Design Pattern:
        Allow an object to pass a request along a chain of potential handlers. Each handler in the chain decides either
        to process the request or pass it to the next handler.

    Bridge Design Pattern: (Class Explosion ko prevent karta hai ye)
        Definition:  Bridge decouples an abstraction (High Level Part e.g. CAR) from its implementation (Low Level Part
        eg Engine), so that both can vary independently.
        Difference b/w Strategy and Bridge Pattern:
            Intent ka difference hai dono me.

    Builder Design Pattern:
        Problems when builder design pattern is not used:
            1. Constructor Overloading (Telescoping) -> Making too many constructors based on use case
            2. Mutable -> getters and setters make the object mutable and sometimes immutability is desired.
            3. Inconsistent state problem -> Runtime error rather than compile time error (maybe since all the values
                                             were supposed to be set using setters are not set and the execution method
                                             was called).
            4. Scattered Validation -> In order to prevent object from going to inconsistent state, validation is
                                       applied in every step and everywhere and this problem is called scattered
                                       validation.
            There are three ways of using builder design pattern:
                - Simple Builder
                - Builder with Director : Simple Builder + (default)/(commonly used) methods
                - Step Builder : step by step calls, here we make interfaces of withMethods that are used in above two.
         Definition: Builder separates the construction of a complex object from its representation.
*/

public class DesignPatterns {
    public static void main(String[] args){

    }
}
