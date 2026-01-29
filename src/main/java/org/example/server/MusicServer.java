package org.example.server;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import org.example.models.Song;
import org.example.repository.DatabaseManager;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicServer {
    private final Gson gson = new Gson();

    public void start() throws Exception {
        // Создаем сервер на порту 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Путь /api/songs
        server.createContext("/api/songs", exchange -> {
            if ("GET".equals(exchange.getRequestMethod())) {
                List<Song> songs = getAllSongsFromDb();
                String response = gson.toJson(songs); // Конвертация в JSON

                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
        });

        System.out.println("Сервер запущен на http://localhost:8080/api/songs");
        server.start();
    }

    private List<Song> getAllSongsFromDb() {
        List<Song> songs = new ArrayList<>();
        String query = "SELECT s.title, s.duration_seconds, s.play_count, a.name FROM Song s JOIN Artist a ON s.artist_id = a.artist_id";

        try (Connection conn = DatabaseManager.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                songs.add(new Song(
                        rs.getString("title"),
                        rs.getInt("duration_seconds"),
                        rs.getString("name"),
                        rs.getInt("play_count")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songs;
    }
}