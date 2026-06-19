package LLD.LLDQuestions.MusicPlayer.strategies;

import LLD.LLDQuestions.MusicPlayer.models.Playlist;
import LLD.LLDQuestions.MusicPlayer.models.Song;

public class SequentialPlayStrategy implements PlayStrategy{
    private Playlist playlist;
    private int index;

    @Override
    public void setPlaylist(Playlist playlist){
        this.playlist = playlist;
    }


    @Override
    public boolean hasNext(){
        if(index+1<playlist.getSongList().size()){
            index+=1;
            return true;
        }
        return false;
    }

    @Override
    public Song next(){
        return playlist.getSongList().get(index);
    }

    @Override
    public boolean hasPrevious(){
        if(index>0){
            index-=1;
            return true;
        }
        return false;
    }

    @Override
    public Song previous(){
        return playlist.getSongList().get(index);
    }

}
