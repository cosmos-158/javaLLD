package LLD.LLDQuestions.MusicPlayer;

public class Main {
    public static void main(String[] args) {
        try {
            MusicPlayerApplication application = MusicPlayerApplication.getInstance();

            // Populate library
            application.createSongInLibrary("Kesariya", "Arijit Singh");
            application.createSongInLibrary("Chaiyya Chaiyya", "Sukhwinder Singh");
            application.createSongInLibrary("Tum Hi Ho", "Arijit Singh");
            application.createSongInLibrary("Jai Ho", "A. R. Rahman");
            application.createSongInLibrary("Zinda", "Siddharth Mahadevan");
            System.out.println("------------------Added Songs to Library-----------\n");

            // Create playlist and add songs
            application.createPlaylist("Bollywood Vibes");
            application.addSongToPlaylist("Bollywood Vibes", "Kesariya");
            application.addSongToPlaylist("Bollywood Vibes", "Chaiyya Chaiyya");
            application.addSongToPlaylist("Bollywood Vibes", "Tum Hi Ho");
            application.addSongToPlaylist("Bollywood Vibes", "Jai Ho");
            System.out.println("------------------Created Playlist----------------\n");

            // Connect device
            System.out.println("------------Connecting to device--------");
            application.connectAudioDevice("bluetooth");

            //Play/pause a single song
            application.playSingleSong("Zinda");
            application.pauseCurrentSong("Zinda");
            application.playSingleSong("Zinda");  // resume

            System.out.println("\n-- Sequential Playback --\n");
            application.selectPlayStrategy("sequential");
            application.loadPlaylist("Bollywood Vibes");
            application.playAllTracksInPlaylist();

            System.out.println("\n-- Random Playback --\n");
            application.selectPlayStrategy("random");
            application.loadPlaylist("Bollywood Vibes");
            application.playAllTracksInPlaylist();


            System.out.println("\n-- Play Previous in Sequential --\n");
            application.selectPlayStrategy("sequential");
            application.loadPlaylist("Bollywood Vibes");
            application.playAllTracksInPlaylist();
            System.out.println("------------------------");

            application.playPreviousTrackInPlaylist();
            application.playPreviousTrackInPlaylist();

        } catch (Exception error) {
            System.err.println("Error: " + error.getMessage());
        }
    }

}
