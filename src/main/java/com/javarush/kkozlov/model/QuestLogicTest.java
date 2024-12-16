package com.javarush.kkozlov.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class QuestLogicTest {

    @Test
    public void testInitialState() {
        QuestLogic quest = new QuestLogic();
        assertFalse(quest.isGameOver());
    }

    @Test
    public void testExplorePath() {
        QuestLogic quest = new QuestLogic();
        String result = quest.processAction("explore");
        assertEquals("You enter a dark forest...", result);
        assertFalse(quest.isGameOver());
    }

    @Test
    public void testWaitPath() {
        QuestLogic quest = new QuestLogic();
        String result = quest.processAction("wait");
        assertEquals("You decide to wait and find a friendly village.", result);
        assertTrue(quest.isGameOver());
    }

    @Test
    public void testGameOverAfterExplore() {
        QuestLogic quest = new QuestLogic();
        quest.processAction("explore");
        String result = quest.processAction("anything");
        assertEquals("A monster attacks you. Game Over.", result);
        assertTrue(quest.isGameOver());
    }
}
