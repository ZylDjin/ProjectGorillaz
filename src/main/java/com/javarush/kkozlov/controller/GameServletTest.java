package com.javarush.kkozlov.controller;

import jakarta.servlet.http.HttpSession;
import com.javarush.kkozlov.model.QuestLogic;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

import static org.junit.jupiter.api.Assertions.*;

class GameServletTest {

    @Test
    void testGameServletSessionPersistence() throws Exception {
        GameServlet servlet = new GameServlet();
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockHttpSession session = new MockHttpSession();

        request.setSession(session);
        request.setParameter("action", "explore");

        servlet.doPost(request, response);

        HttpSession actualSession = request.getSession();
        QuestLogic quest = (QuestLogic) actualSession.getAttribute("quest");

        assertNotNull(quest);
        assertFalse(quest.isGameOver());
    }

    @Test
    void testGameServletGameOver() throws Exception {
        GameServlet servlet = new GameServlet();
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockHttpSession session = new MockHttpSession();

        request.setSession(session);
        request.setParameter("action", "wait");

        servlet.doPost(request, response);

        HttpSession actualSession = request.getSession();
        QuestLogic quest = (QuestLogic) actualSession.getAttribute("quest");

        assertNotNull(quest);
        assertTrue(quest.isGameOver());
    }
}
