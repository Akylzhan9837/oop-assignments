import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Artist artist = new Artist("hashtagsamal");
        Playlist playlist = new Playlist("Best Hits", artist);
        artist.addPlaylist(playlist);

        Song s1 = new Song("Tusim", 180, artist, 2477);
        Song s2 = new Song("Prisnilos", 200, artist, 2023);
        Song s3 = new Song("Sergek", 190, artist, 1784);

        playlist.addSong(s1);
        playlist.addSong(s2);
        playlist.addSong(s3);

        // 2️⃣ Сохраняем объекты в БД
        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/music_streaming_library", "postgres", "1769")) {

            // Сохраняем артиста
            String sqlArtist = "INSERT INTO Artist(name, country) VALUES (?, ?) RETURNING artist_id";
            try (PreparedStatement ps = con.prepareStatement(sqlArtist)) {
                ps.setString(1, artist.getName());
                ps.setString(2, "");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int artistId = rs.getInt("artist_id");

                    String sqlPlaylist = "INSERT INTO Playlist(playlist_name, created_date) VALUES (?, CURRENT_DATE) RETURNING playlist_id";
                    try (PreparedStatement ps2 = con.prepareStatement(sqlPlaylist)) {
                        ps2.setString(1, playlist.getTitle());
                        ResultSet rs2 = ps2.executeQuery();
                        if (rs2.next()) {
                            int playlistId = rs2.getInt("playlist_id");

                            // Сохраняем песни и связываем с плейлистом
                            String sqlSong = "INSERT INTO Song(title, duration_seconds, play_count, artist_id) VALUES (?, ?, ?, ?) RETURNING song_id";
                            String sqlLink = "INSERT INTO Playlist_Song(playlist_id, song_id) VALUES (?, ?)";

                            for (Song s : playlist.getSongs()) {
                                try (PreparedStatement psSong = con.prepareStatement(sqlSong)) {
                                    psSong.setString(1, s.getTitle());
                                    psSong.setDouble(2, s.getDuration());
                                    psSong.setInt(3, s.getPlayCount());
                                    psSong.setInt(4, artistId);

                                    // executeQuery вызываем у PreparedStatement
                                    try (ResultSet rsSong = psSong.executeQuery()) {
                                        if (rsSong.next()) {
                                            int songId = rsSong.getInt("song_id");

                                            // связываем песню с плейлистом
                                            try (PreparedStatement psLink = con.prepareStatement(sqlLink)) {
                                                psLink.setInt(1, playlistId);
                                                psLink.setInt(2, songId);
                                                psLink.executeUpdate();
                                        }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("All data saved to DB ✅");
    }
}

