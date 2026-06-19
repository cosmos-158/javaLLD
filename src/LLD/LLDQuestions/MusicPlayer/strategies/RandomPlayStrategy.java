package LLD.LLDQuestions.MusicPlayer.strategies;

import LLD.LLDQuestions.MusicPlayer.models.Playlist;
import LLD.LLDQuestions.MusicPlayer.models.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class RandomPlayStrategy implements PlayStrategy{
    private Playlist playlist;
    private Random random;
    private int index;
    private Stack<Song> history;
    private List<Boolean> visited;

    public RandomPlayStrategy(){
        this.random = new Random();
        this.history = new Stack<>();
        this.visited = new ArrayList<>(playlist.getSongList().size());
    }

    @Override
    public void setPlaylist(Playlist playlist){
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext(){
        this.index = random.nextInt(playlist.getSongList().size());
        if(index<playlist.getSongList().size() && visited.get(index) == false){
            return true;
        }
        return false;
    }

    @Override
    public Song next(){
        history.push(playlist.getSongList().get(index));
        visited.set(index, true);
        return playlist.getSongList().get(this.index);
    }

    @Override
    public boolean hasPrevious(){
        if(!history.isEmpty())
            return true;
        return false;
    }

    @Override
    public Song previous(){
        return history.pop();
    }

}
