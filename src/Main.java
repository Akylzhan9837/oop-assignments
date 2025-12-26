public class Main {
    public static void main(String[] args) {

        Artist artist = new Artist("hashtagsamal");
        Album album = new Album("Best Hits", artist);
        artist.addAlbum(album);

        Song s1 = new Song("Tusim", 180, artist, 2477);
        Song s2 = new Song("Prisnilos", 200, artist, 2023);
        Song s3 = new Song("Sergek", 190, artist, 1784);

        album.addSong(s1);
        album.addSong(s2);
        album.addSong(s3);

        MusicLibrary library = new MusicLibrary();
        library.add(s1);
        library.add(s2);
        library.add(s3);

        System.out.println("🔍 Search 'si':");
        library.searchByTitle("si").forEach(System.out::println);

        System.out.println("\n⏱ Sorted by duration:");
        library.sortByDuration().forEach(MediaItem::play);
    }
}
