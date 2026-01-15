import java.util.ArrayList;
import java.util.List;

public class Artist {
    private final String name;
    private final List<Playlist> playlists;

    public Artist(String name) {
        this.name = name;
        this.playlists = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAlbum(Playlist playlist) {
        playlists.add(playlist);
    }

    public List<Playlist> getAlbums() {
        return playlists;
    }

    @Override
    public String toString() {
        return "Artist: " + name + ", playlists: " + playlists.size();
    }

    public void addPlaylist(Playlist playlist) {
    }
}
