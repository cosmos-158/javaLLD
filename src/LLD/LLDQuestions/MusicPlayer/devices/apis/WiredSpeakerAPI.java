package LLD.LLDQuestions.MusicPlayer.devices.apis;

import LLD.LLDQuestions.MusicPlayer.models.Song;

public class WiredSpeakerAPI {
    public void playSongviaWiredSpeaker(Song song){
        System.out.println("Playing "+song.getName() + " by" + song.getArtist() + " through Wired Speaker device");
    }
}
