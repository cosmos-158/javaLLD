package LLD.LLDQuestions.MusicPlayer.managers;

import LLD.LLDQuestions.MusicPlayer.devices.DeviceInterface;
import LLD.LLDQuestions.MusicPlayer.factories.DeviceFactory;

public class DeviceManager {
    public static DeviceManager deviceManager;
    private DeviceInterface deviceInterface;

    private DeviceManager(){
        this.deviceInterface = null;
    }

    public static DeviceManager getInstance(){
        if(deviceManager==null)
            deviceManager =  new DeviceManager();
        return deviceManager;
    }

    public void connect(String type){
        this.deviceInterface = DeviceFactory.createDevice(type);
        if(type.equalsIgnoreCase("bluetooth"))
            System.out.println("Connected to bluetooth Device");
        else
            System.out.println("Connected to Wired Device");
    }

    public DeviceInterface getAudioDevice(){
        if(deviceInterface==null){
            throw new RuntimeException("Connect to device first..");
        }
        return deviceInterface;
    }

    public boolean hasOutputDevice() {
        return deviceInterface != null;
    }

}
