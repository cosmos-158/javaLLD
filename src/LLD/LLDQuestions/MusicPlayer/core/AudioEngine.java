package LLD.LLDQuestions.MusicPlayer.core;

import LLD.LLDQuestions.MusicPlayer.devices.DeviceInterface;
import LLD.LLDQuestions.MusicPlayer.models.Song;

public class AudioEngine {
    private boolean isPaused;

    public AudioEngine(){

    }

    public void playSong(DeviceInterface device, Song song){
        if(song==null){
            throw new RuntimeException("Cannot play a null song. ");
        }
        if(isPaused==false){
            device.playAudio(song);
        } else {
            System.out.println("Resuming : " + song.getName() + " by "+ song.getArtist());
            isPaused = false;
        }
    }

    public void pauseSong(Song song){
        if(song==null){
            throw new RuntimeException("No song playing..");
        } else if(isPaused) {
            throw new RuntimeException("Song already paused..");
        } else {
            isPaused = true;
            System.out.println("Paused : " + song.getName() + " by " + song.getArtist());
        }
    }

}
