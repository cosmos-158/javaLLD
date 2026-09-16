package LLD.LLDQuestions.MusicPlayer.devices.apis;

import LLD.LLDQuestions.MusicPlayer.models.Song;

public class BluetoothDeviceAPI {
    public void playSongviaBluetooth(Song song){
        System.out.println("Playing "+song.getName() + " by " + song.getArtist() + " through bluetooth device");
    }
}
