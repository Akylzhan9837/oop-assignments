import java.util.ArrayList;
import java.util.List;

public class Album {
    private final String title;
    private final Artist artist;
    private final List<Song> songs;

    public Album(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return "Playlist: " + title + " by " + artist.getName() +
                "\nSongs: " + songs.toString();
    }
}
