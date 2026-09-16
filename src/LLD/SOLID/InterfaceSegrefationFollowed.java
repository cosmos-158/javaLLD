package LLD.SOLID;

interface TwoD{
    int area();
}

interface ThreeD{
    int area();
    int volume();
}

class SquareShape implements TwoD{
    int length;
    public SquareShape(int length){
        this.length = length;
    }

    public int area(){
        return this.length*this.length;
    }
}

class CircleShape implements TwoD{
    int radius;
    public CircleShape(int radius){
        this.radius = radius;
    }

    public int area(){
        return (int)3.14*this.radius*this.radius;
    }
}

class CubeShape implements ThreeD{
    int length;
    public CubeShape(int length){
        this.length = length;
    }

    public int area(){
        return 6*this.length*this.length;
    }
    public int volume(){
        return this.length*this.length*this.length;
    }
}

public class InterfaceSegrefationFollowed {
    public static void main(String[] args){
        TwoD square = new SquareShape(4);
        TwoD circle = new CircleShape(4);
        ThreeD cube = new CubeShape(4);

        System.out.println("Area of square: " + square.area());
        System.out.println("Area of circle: " + circle.area());
        System.out.println("Area of cube: " + cube.area());
        System.out.println("Volume of cube: " + cube.volume());

    }
}
