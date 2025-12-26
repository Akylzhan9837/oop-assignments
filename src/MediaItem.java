public abstract class MediaItem {
    protected String title;
    protected int duration;

    public MediaItem(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public abstract void play();

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}
