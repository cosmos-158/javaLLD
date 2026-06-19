package LLD.LLDQuestions.MusicPlayer.managers;

import LLD.LLDQuestions.MusicPlayer.models.Playlist;
import LLD.LLDQuestions.MusicPlayer.models.Song;

import java.util.HashMap;
import java.util.Map;

public class PlaylistManager {
    public static PlaylistManager playlistManager = null;
    private HashMap<String, Playlist> playlists;

    private PlaylistManager(){
        this.playlists = new HashMap<>();
    }

    public static PlaylistManager getManagerInstance(){
        if(playlistManager==null)
            playlistManager = new PlaylistManager();
        return playlistManager;
    }

    public void createPlaylist(String name){
        if(playlists.containsKey(name)){
            throw new RuntimeException("Playlist '"+name+"' already exists");
        }
        playlists.put(name, new Playlist(name));
    }

    public void addSongToPlaylist(String name, Song song){
        playlists.get(name).addSong(song);
    }

    public Playlist getPlaylist(String name){
        return playlists.get(name);
    }

}
