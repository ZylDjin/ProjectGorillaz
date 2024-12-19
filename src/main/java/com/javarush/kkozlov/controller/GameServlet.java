package com.javarush.kkozlov.controller;

import com.javarush.kkozlov.model.QuestLogic;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class GameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем действие пользователя
        String action = request.getParameter("action");

        // Получаем текущую сессию
        HttpSession session = request.getSession();

        // Получаем объект логики квеста из сессии или создаем новый
        QuestLogic questLogic = (QuestLogic) session.getAttribute("questLogic");
        if (questLogic == null) {
            questLogic = new QuestLogic();
            session.setAttribute("questLogic", questLogic);
        }

        // Обрабатываем действие и получаем результат
        String result = questLogic.proceed(action);

        // Если игра завершена
        if (questLogic.isGameOver()) {
            session.setAttribute("message", "Игра окончена. Хотите начать заново?");
            request.setAttribute("result", result);
            request.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(request, response);
            return;
        }

        // Логика для разветвленных действий
        if (result.contains("дом") || result.contains("шум")) { // Пример проверки ключевых слов
            request.setAttribute("message", result);
            request.getRequestDispatcher("/WEB-INF/views/branch.jsp").forward(request, response);
        } else {
            // Для остальных случаев отображаем основное игровое окно
            request.setAttribute("result", result);
            request.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Перенаправляем GET-запросы на старт игры
        HttpSession session = request.getSession();
        QuestLogic questLogic = (QuestLogic) session.getAttribute("questLogic");
        if (questLogic == null) {
            questLogic = new QuestLogic();
            session.setAttribute("questLogic", questLogic);
        }

        request.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(request, response);
    }
}


