package com.javarush.kkozlov.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsTest {

    @Test
    void testSingletonInstance() {
        Stats stats1 = Stats.getInstance();
        Stats stats2 = Stats.getInstance();
        assertSame(stats1, stats2);
    }

    @Test
    void testIncrementGames() {
        Stats stats = Stats.getInstance();
        stats.incrementGames();
        stats.incrementGames();
        assertEquals(2, stats.getGamesPlayed());
    }
}
