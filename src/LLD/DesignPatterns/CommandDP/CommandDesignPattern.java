package LLD.DesignPatterns.CommandDP;

import java.util.ArrayList;
import java.util.List;

// Command Interface
interface Command{
    void execute();
    void undo();
}

// concrete class1
class FanCommand implements Command{
    private Fan fan;
    public FanCommand(Fan fan){
        this.fan = fan;
    }
    public void execute(){
        fan.on();
    }
    public void undo(){
        fan.off();
    }
}

// concrete class2
class LightCommand implements Command{
    private Light light;
    public LightCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.on();
    }
    public void undo(){
        light.off();
    }
}

// Receiver1
class Fan{
    public void on(){
        System.out.println("Fan turned on!");
    }
    public void off(){
        System.out.println("Fan turned off!");
    }
}
// Receiver2
class Light{
    public void on(){
        System.out.println("Light turned on!");
    }
    public void off(){
        System.out.println("Light turned off!");
    }
}

// Controller
class Remote{
    private static final int numButtons = 4;
    private final List<Command> commandList = new ArrayList<>();
    private final List<Boolean> buttonStatus = new ArrayList<>();

    public Remote(){
        for(int i=0;i<numButtons;i++){
            this.commandList.add(null);
            this.buttonStatus.add(false);
        }
    }

    public void setCommand(int index, Command command){
        if(index>=0 && index < numButtons){
            commandList.set(index,command);
        }
    }

    public void pressButton(int index){
        if(index>=0 && index < numButtons && commandList.get(index)!=null) {
            if (buttonStatus.get(index) == false) {
                commandList.get(index).execute();

            } else {
                commandList.get(index).undo();
            }
            buttonStatus.set(index, !buttonStatus.get(index));
        } else{
            System.out.println("No command assigned at button "+ index);
        }
    }

}

public class CommandDesignPattern {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();

        Remote remote = new Remote();
        remote.setCommand(0,new LightCommand(light));
        remote.setCommand(1,new FanCommand(fan));

        remote.pressButton(0);
        remote.pressButton(0);

        System.out.println("--------------------");

        remote.pressButton(1);
        remote.pressButton(1);

        System.out.println(" --------------------");

        remote.pressButton(2);
    }
}
