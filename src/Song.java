public class Song {
    private final String title;
    private final int duration;
    private final Artist artist;
    private int playCount;

    public Song(String title, int duration, Artist artist, int playCount) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
        this.playCount = playCount;
    }

    public void play() {
        playCount++;
        System.out.println("Playing: " + title);
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Artist getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return title + " (" + duration + " sec) - " + artist.getName() + " | plays: " + playCount;
    }
}
