package com.javarush.kkozlov.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ResetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate(); // Сброс текущей сессии
        response.sendRedirect("Welcome"); // Перенаправление на стартовую страницу
    }
}
