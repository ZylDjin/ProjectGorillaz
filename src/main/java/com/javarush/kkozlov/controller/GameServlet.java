package com.javarush.kkozlov.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.javarush.kkozlov.service.QuestService;
import com.javarush.kkozlov.model.QuestLogic;

import java.io.IOException;

public class GameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // Инициализируем QuestLogic, если его нет в сессии
        QuestLogic questLogic = (QuestLogic) session.getAttribute("quest");
        if (questLogic == null) {
            questLogic = new QuestLogic();
            session.setAttribute("quest", questLogic);
        }

        // Создаем QuestService
        QuestService questService = new QuestService(questLogic);

        // Получаем действие от пользователя
        String action = req.getParameter("action");

        // Обрабатываем действие
        String result = questService.processAction(action);

        // Проверяем завершение игры
        if (questService.isGameOver()) {
            resp.sendRedirect("result"); // Перенаправление на результат
        } else {
            req.setAttribute("result", result);
            req.getRequestDispatcher("/WEB-INF/views/Game.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/Game.jsp").forward(req, resp);
    }
}


