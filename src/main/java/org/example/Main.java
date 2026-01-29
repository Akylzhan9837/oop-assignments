package org.example;

import org.example.server.MusicServer;

public class Main {
    public static void main(String[] args) {
        try {
            MusicServer server = new MusicServer();
            server.start();
        } catch (Exception e) {
            System.err.println("Ошибка запуска сервера: " + e.getMessage());
            e.printStackTrace();
        }
    }
}