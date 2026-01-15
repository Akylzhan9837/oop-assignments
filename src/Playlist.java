import java.util.*;

public class Playlist {

    private final String title;
    private final Artist artist;
    private final List<Song> songs;

    public Playlist(String title, Artist artist) {
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
        return "Playlist: " + title + "" + artist.getName() +
                ", tracks: " + songs.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Playlist playlist)) return false;
        return title.equals(playlist.title) &&
                artist.equals(playlist.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist);
    }
}
