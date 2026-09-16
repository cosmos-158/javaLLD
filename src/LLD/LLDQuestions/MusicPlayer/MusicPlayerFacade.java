package LLD.LLDQuestions.MusicPlayer;

import LLD.LLDQuestions.MusicPlayer.core.AudioEngine;
import LLD.LLDQuestions.MusicPlayer.devices.DeviceInterface;
import LLD.LLDQuestions.MusicPlayer.managers.DeviceManager;
import LLD.LLDQuestions.MusicPlayer.managers.PlaylistManager;
import LLD.LLDQuestions.MusicPlayer.managers.StrategyManager;
import LLD.LLDQuestions.MusicPlayer.models.Playlist;
import LLD.LLDQuestions.MusicPlayer.models.Song;
import LLD.LLDQuestions.MusicPlayer.strategies.PlayStrategy;

public class MusicPlayerFacade {
    private static MusicPlayerFacade musicPlayerFacade = null;
    private AudioEngine audioEngine;
    private PlayStrategy playStrategy;
    private Playlist playlist;

    private MusicPlayerFacade(){
        this.audioEngine = new AudioEngine();
        this.playStrategy = null;
        this.playlist = null;
    }

    public static synchronized MusicPlayerFacade getInstance() {
        if (musicPlayerFacade == null) {
            musicPlayerFacade = new MusicPlayerFacade();
        }
        return musicPlayerFacade;
    }

    public void connectDevice(String type){
        DeviceManager.getInstance().connect(type);
    }

    public void setPlayStrategy(String type){
        this.playStrategy = StrategyManager.getInstance().getPlayStrategy(type);
    }

    public void loadPlaylist(String name){
        this.playlist = PlaylistManager.getManagerInstance().getPlaylist(name);
        playStrategy.setPlaylist(playlist);
    }

    public void playSong(Song song) {
        if (!DeviceManager.getInstance().hasOutputDevice()) {
            throw new RuntimeException("No audio device connected.");
        }
        DeviceInterface device = DeviceManager.getInstance().getAudioDevice();
        audioEngine.playSong(device, song);
    }

    public void pauseSong(Song song){
        audioEngine.pauseSong(song);
    }

    public void playAllTracks() {
        if (playlist == null) {
            throw new RuntimeException("No playlist loaded.");
        }
        while (playStrategy.hasNext()) {
            Song nextSong = playStrategy.next();
            DeviceInterface device = DeviceManager.getInstance().getAudioDevice();
            audioEngine.playSong(device, nextSong);
        }
        System.out.println("Completed playlist: " + playlist.getPlaylistName());
        System.out.println();
    }

    public void playNextTrack() {
        if (playlist == null) {
            throw new RuntimeException("No playlist loaded.");
        }
        if (playStrategy.hasNext()) {
            Song nextSong = playStrategy.next();
            DeviceInterface device = DeviceManager.getInstance().getAudioDevice();
            audioEngine.playSong(device, nextSong);
        } else {
            System.out.println("Completed playlist: " + playlist.getPlaylistName());
            System.out.println();
        }
    }

    public void playPreviousTrack() {
        if (playlist == null) {
            throw new RuntimeException("No playlist loaded.");
        }
        if (playStrategy.hasPrevious()) {
            Song prevSong = playStrategy.previous();
            DeviceInterface device = DeviceManager.getInstance().getAudioDevice();
            audioEngine.playSong(device, prevSong);
        } else {
            System.out.println("Completed playlist: " + playlist.getPlaylistName());
            System.out.println();
        }
    }

}
