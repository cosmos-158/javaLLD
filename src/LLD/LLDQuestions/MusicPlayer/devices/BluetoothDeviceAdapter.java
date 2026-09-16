package LLD.LLDQuestions.MusicPlayer.devices;

import LLD.LLDQuestions.MusicPlayer.devices.apis.BluetoothDeviceAPI;
import LLD.LLDQuestions.MusicPlayer.models.Song;

public class BluetoothDeviceAdapter implements DeviceInterface{
    private BluetoothDeviceAPI bluetoothDeviceAPI;

    public BluetoothDeviceAdapter(BluetoothDeviceAPI bluetoothDeviceAPI){
        this.bluetoothDeviceAPI = bluetoothDeviceAPI;
    }

    public void playAudio(Song song){
        bluetoothDeviceAPI.playSongviaBluetooth(song);
    }

}
