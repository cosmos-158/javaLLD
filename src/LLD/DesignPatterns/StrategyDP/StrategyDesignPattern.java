package LLD.DesignPatterns.StrategyDP;

// Strategy to Talk
interface Talkable{
    void talk();
}

class TalkableRobot implements Talkable{
    public void talk(){
        System.out.println("This robot can talk");
    }
}

class NonTalkableRobot implements Talkable{
    public void talk(){
        System.out.println("This robot can't talk");
    }
}

// Strategy to Walk
interface Walkable{
    void walk();
}

class WalkableRobot implements Walkable{
    public void walk(){
        System.out.println("This robot can walk");
    }
}

class NonWalkableRobot implements Walkable{
    public void walk(){
        System.out.println("This robot can't walk");
    }
}

// Strategy to Fly
interface Flyable{
    void fly();
}

class FlyableRobot implements Flyable{
    public void fly(){
        System.out.println("This robot can fly");
    }
}

class NonFlyableRobot implements Flyable{
    public void fly(){
        System.out.println("This robot can't fly");
    }
}


class Robot{
    private final Talkable talkable;
    private final Walkable walkable;
    private final Flyable flyable;

    public Robot(Talkable talkable, Walkable walkable, Flyable flyable){
        this.talkable = talkable;
        this.walkable = walkable;
        this.flyable = flyable;
    }

    public void walk(){
        walkable.walk();
    }

    public void talk(){
        talkable.talk();
    }

    public void fly(){
        flyable.fly();
    }

    public void projection(String type){
        System.out.println("This robot is "+type);
    }
}

public class StrategyDesignPattern {
    public static void main(String[] args){
        Robot robot = new Robot(new TalkableRobot(), new WalkableRobot(), new FlyableRobot());
        robot.projection("Multipurpose");
        robot.talk();
        robot.walk();
        robot.fly();
        System.out.println();
        System.out.println("------------------------");
        Robot chhotaRobot = new Robot(new TalkableRobot(), new WalkableRobot(), new NonFlyableRobot());
        chhotaRobot.projection("Limited Purpose");
        chhotaRobot.talk();
        chhotaRobot.walk();
        chhotaRobot.fly();
    }
}
