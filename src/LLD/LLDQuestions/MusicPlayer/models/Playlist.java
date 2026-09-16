package LLD.LLDQuestions.MusicPlayer.models;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Song> songList;

    public Playlist(String name){
        this.name = name;
        this.songList = new ArrayList<>();
    }

    public void addSong(Song song){
        songList.add(song);
    }

    public void removeSong(Song song){
        songList.remove(song);
    }

    public String getPlaylistName(){
        return this.name;
    }

    public List<Song> getSongList(){
        return songList;
    }

}
