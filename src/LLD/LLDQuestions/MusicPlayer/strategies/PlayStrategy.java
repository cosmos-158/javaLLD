package LLD.LLDQuestions.MusicPlayer.strategies;

import LLD.LLDQuestions.MusicPlayer.models.Playlist;
import LLD.LLDQuestions.MusicPlayer.models.Song;

public interface PlayStrategy {
    boolean hasNext();
    Song next();
    boolean hasPrevious();
    Song previous();
    void setPlaylist(Playlist playlist);
}
