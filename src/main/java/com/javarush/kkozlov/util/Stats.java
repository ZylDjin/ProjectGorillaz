package com.javarush.kkozlov.util;

public class Stats {
    private int gamesPlayed;

    private static Stats instance;

    private Stats() {
        gamesPlayed = 0;
    }

    public static Stats getInstance() {
        if (instance == null) {
            instance = new Stats();
        }
        return instance;
    }

    public void incrementGames() {
        gamesPlayed++;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }
}