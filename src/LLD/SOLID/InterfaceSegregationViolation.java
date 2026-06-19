package LLD.SOLID;

interface Shape{
    int area();
    int volume();
}

class Square implements Shape{
    int length;
    public Square(int length){
        this.length = length;
    }

    public int area(){
        return this.length*this.length;
    }

    public int volume(){
        throw new UnsupportedOperationException("Volume not applicable for square");
    }
}

class Circle implements Shape{
    int radius;
    public Circle(int radius){
        this.radius = radius;
    }

    public int area(){
        return (int)3.14*this.radius*this.radius;
    }

    public int volume(){
        throw new UnsupportedOperationException("Volume not applicable for square");
    }
}

class Cube implements Shape{
    int length;
    public Cube(int length){
        this.length = length;
    }

    public int area(){
        return 6*this.length*this.length;
    }

    public int volume(){
        return this.length*this.length*this.length;
    }
}

public class InterfaceSegregationViolation {
    public static void main(String[] args){
        Shape square = new Square(5);
        Shape circle = new Circle(5);
        Shape cube = new Cube(5);

        System.out.println("Area of square: " + square.area());

        try{
            System.out.println("Volume of square: " + square.volume());
        }catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Area of circle: " + circle.area());

        try{
            System.out.println("Volume of circle: " + circle.volume());
        }catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Area of cube: " + cube.area());
        System.out.println("Volume of cube: " + cube.volume());

    }
}
