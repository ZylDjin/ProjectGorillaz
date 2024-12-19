package com.javarush.kkozlov.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для QuestLogic.
 */
public class QuestLogicTest {

    @Test
    public void testInitialState() {
        QuestLogic quest = new QuestLogic();
        assertEquals("Начальное состояние.", quest.getCurrentStateDescription());
        assertFalse(quest.isGameOver());
    }

    @Test
    public void testExplorePath() {
        QuestLogic quest = new QuestLogic();
        String result = quest.proceed("explore");
        assertEquals("Вы нашли дом с закрытой дверью.", result);
        assertFalse(quest.isGameOver());
    }

    @Test
    public void testWaitPath() {
        QuestLogic quest = new QuestLogic();
        String result = quest.proceed("wait");
        assertEquals("Вы остались на месте, и наступила ночь.", result);
        assertTrue(quest.isGameOver());
    }

    @Test
    public void testGameReset() {
        QuestLogic quest = new QuestLogic();
        quest.proceed("explore");
        quest.reset();
        assertEquals("Начальное состояние.", quest.getCurrentStateDescription());
    }
}
