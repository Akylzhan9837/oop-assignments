import java.util.Objects;

public class Song extends MediaItem {

    private final Artist artist;
    private int playCount;

    public Song(String title, int duration, Artist artist, int playCount) {
        super(title, duration);     // передаём данные в MediaItem
        this.artist = artist;
        this.playCount = playCount;
    }

    @Override
    public void play() {
        playCount++;
        System.out.println(title + " (" + duration + " sec) - " +
                artist.getName() + " | plays: " + playCount);
    }


    public Artist getArtist() {
        return artist;
    }

    public int getPlayCount() {
        return playCount;
    }

    @Override
    public String toString() {
        return title + " (" + duration + " sec) - " +
                artist.getName() + " | plays: " + playCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song song)) return false;
        return title.equals(song.title) &&
                artist.equals(song.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist);
    }
}
