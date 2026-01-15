import java.util.ArrayList;
import java.util.List;

public class MusicLibrary {
    private final List<MediaItem> items = new ArrayList<>();

    public void add(MediaItem item) {
        items.add(item);
    }

    public List<MediaItem> searchByTitle(String keyword) {
        List<MediaItem> result = new ArrayList<>();
        for (MediaItem item : items) {
            if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    public List<MediaItem> sortByDuration() {
        List<MediaItem> sorted = new ArrayList<>(items);
        sorted.sort((a, b) -> Integer.compare(a.getDuration(), b.getDuration()));
        return sorted;
    }
}
