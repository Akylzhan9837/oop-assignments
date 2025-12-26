    private final Artist artist;
    private int playCount;

    public Song(String title, int duration, Artist artist, int playCount) {
        this.artist = artist;
        this.playCount = playCount;
    }

    public void play() {
        playCount++;
    }

    public Artist getArtist() {
        return artist;
    }

    @Override
    public String toString() {
    }
}
