package com.javarush.kkozlov.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.QuestLogic;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        QuestLogic quest = (QuestLogic) session.getAttribute("quest");

        if (quest == null) {
            quest = new QuestLogic();
            session.setAttribute("quest", quest);
        }

        String result = quest.processAction(action);
        session.setAttribute("quest", quest);

        if (quest.isGameOver()) {
            resp.sendRedirect("result");
        } else {
            req.setAttribute("result", result);
            req.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(req, resp);
        }
    }
}
