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

        System.out.println(album);

        System.out.println("Треки:");
        for (Song song : album.getSongs()) {
            System.out.println(song);
        }
    }
}
