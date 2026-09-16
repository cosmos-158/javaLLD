package LLD.LLDQuestions.MusicPlayer;

import LLD.LLDQuestions.MusicPlayer.devices.DeviceInterface;
import LLD.LLDQuestions.MusicPlayer.managers.PlaylistManager;
import LLD.LLDQuestions.MusicPlayer.models.Song;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayerApplication {
    private static MusicPlayerApplication instance = null;
    private List<Song> songLibrary;

    private MusicPlayerApplication() {
        songLibrary = new ArrayList<>();
    }

    public static synchronized MusicPlayerApplication getInstance() {
        if (instance == null) {
            instance = new MusicPlayerApplication();
        }
        return instance;
    }

    public void createSongInLibrary(String title, String artist) {
        Song newSong = new Song(title, artist);
        songLibrary.add(newSong);
    }

    public Song findSongByTitle(String name) {
        for (Song s : songLibrary) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public void createPlaylist(String playlistName) {
        PlaylistManager.getManagerInstance().createPlaylist(playlistName);
    }

    public void addSongToPlaylist(String playlistName, String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found in library.");
        }
        PlaylistManager.getManagerInstance().addSongToPlaylist(playlistName, song);
    }

    public void connectAudioDevice(String deviceType) {
        MusicPlayerFacade.getInstance().connectDevice(deviceType);
    }

    public void selectPlayStrategy(String strategyType) {
        MusicPlayerFacade.getInstance().setPlayStrategy(strategyType);
    }

    public void loadPlaylist(String playlistName) {
        MusicPlayerFacade.getInstance().loadPlaylist(playlistName);
    }

    public void playSingleSong(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicPlayerFacade.getInstance().playSong(song);
    }

    public void pauseCurrentSong(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicPlayerFacade.getInstance().pauseSong(song);
    }

    public void playAllTracksInPlaylist() {
        MusicPlayerFacade.getInstance().playAllTracks();
    }

    public void playPreviousTrackInPlaylist() {
        MusicPlayerFacade.getInstance().playPreviousTrack();
    }

}
