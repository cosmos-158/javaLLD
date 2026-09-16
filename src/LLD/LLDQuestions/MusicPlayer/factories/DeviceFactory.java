package LLD.LLDQuestions.MusicPlayer.factories;

import LLD.LLDQuestions.MusicPlayer.devices.BluetoothDeviceAdapter;
import LLD.LLDQuestions.MusicPlayer.devices.DeviceInterface;
import LLD.LLDQuestions.MusicPlayer.devices.WiredSpeakerDeviceAdapter;
import LLD.LLDQuestions.MusicPlayer.devices.apis.BluetoothDeviceAPI;
import LLD.LLDQuestions.MusicPlayer.devices.apis.WiredSpeakerAPI;


public class DeviceFactory {
    public static DeviceInterface createDevice(String type){
        if(type.equalsIgnoreCase("bluetooth"))
            return new BluetoothDeviceAdapter( new BluetoothDeviceAPI());
        return new WiredSpeakerDeviceAdapter( new WiredSpeakerAPI());
    }
}
