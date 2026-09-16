package oops;

// single level inheritance
// multi level inheritance
// Hierarchical inheritance
// Hybrid inheritance
// multiple inheritance is not supported in java X


class Calculator{
    int num1;
    int num2;

    public int add(int num1, int num2){
        return num1+num2;
    }

    public int sub(int num1, int num2){
        return num1-num2;
    }

}

class AdvCalc extends Calculator{
    int num1;
    int num2;

    public int multiply(int num1, int num2){
        return num1*num2;
    }

    public int divide(int num1, int num2){
        if(num2==0) {
            System.out.println("Division by 0 doesn't make any sense");
            return -1;
        }
        return num1/num2;
    }

}

public class Inheritance {
    public static void main(String[] args){
        Calculator cal = new Calculator();
        int res1 = cal.add(2,3);
        int res2 = cal.sub(3,2);

        System.out.println(res1);
        System.out.println(res2);

        AdvCalc acal = new AdvCalc();

        int ar1 = acal.add(2,3);
        int ar2 = acal.sub(3,2);
        int ar3 = acal.multiply(3,2);
        int ar4 = acal.divide(4,2);

        System.out.println(ar1);
        System.out.println(ar2);
        System.out.println(ar3);
        System.out.println(ar4);


    }
}
