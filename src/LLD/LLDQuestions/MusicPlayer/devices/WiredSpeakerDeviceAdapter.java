package LLD.LLDQuestions.MusicPlayer.devices;

import LLD.LLDQuestions.MusicPlayer.devices.apis.BluetoothDeviceAPI;
import LLD.LLDQuestions.MusicPlayer.devices.apis.WiredSpeakerAPI;
import LLD.LLDQuestions.MusicPlayer.models.Song;

public class WiredSpeakerDeviceAdapter implements DeviceInterface{
    private WiredSpeakerAPI wiredSpeakerAPI;

    public WiredSpeakerDeviceAdapter(WiredSpeakerAPI wiredSpeakerAPI){
        this.wiredSpeakerAPI = wiredSpeakerAPI;
    }

    @Override
    public void playAudio(Song song){
        wiredSpeakerAPI.playSongviaWiredSpeaker(song);
    }
}
