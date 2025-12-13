import java.util.ArrayList;
import java.util.List;

public class Artist {
    private final String name;
    private final List<Album> albums;

    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public List<Album> getAlbums() {
        return albums;
    }

    @Override
    public String toString() {
        return "Artist: " + name + ", albums: " + albums.size();
    }
}
