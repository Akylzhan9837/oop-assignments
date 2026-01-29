package org.example.models;

public class Song {
    private String title;
    private int duration;
    private String artistName;
    private int playCount;

    // Конструктор для создания объекта из данных БД
    public Song(String title, int duration, String artistName, int playCount) {
        this.title = title;
        this.duration = duration;
        this.artistName = artistName;
        this.playCount = playCount;
    }
}