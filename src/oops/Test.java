package oops;
//This has multiple main methods which means multiple entry points. Hence, after compilation we need to give the class
//name whose main method we want to run.
// Commands
//      javac oops/FileName.java
//      java oops/ClassName

// Here File name can be different from className. Only public className should be same as FileName

class Temp{
    public static void main(String[] args){
        System.out.println("Hello from Temp");
    }
}

class A{
    public static void main(String[] args){
        System.out.println("Hello A");
    }
}

class B{
    public static void main(String[] args){
        System.out.println("Hello B");
    }
}